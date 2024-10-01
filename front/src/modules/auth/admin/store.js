import { create } from 'zustand';
import axios from 'axios';

const useUserStore = create((set) => ({
  user: null,
  loading: false,
  error: null,
  token: null,

  login: async (credentials) => {
    set({ loading: true, error: null });
    try {
      const response = await axios.post(`${process.env.REACT_APP_API_URL}/login`, credentials);
      const { token, ...userData } = response.data;
      set({ user: userData, token, loading: false });
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`;
    } catch (error) {
      set({ error: error.response?.data?.message || 'Error en la autenticación', loading: false });
    }
  },

  register: async (data) => {
    set({ loading: true, error: null });
    try {
      const response = await axios.post(`${process.env.REACT_APP_API_URL}/register`, data);
      set({ user: response.data, loading: false });
    } catch (error) {
      set({ error: error.response?.data?.message || 'Error en el registro', loading: false });
    }
  },

  logout: () => {
    localStorage.removeItem('token');
    delete axios.defaults.headers.common['Authorization'];
    set({ user: null, token: null });
  },
}));

export default useUserStore;
