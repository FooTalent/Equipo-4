/* eslint-disable no-undef */
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
      const response = await axios.post(`${process.env.REACT_APP_API_URL}/api/auth/login`, credentials);
      const { token, ...userData } = response.data;
      set({ user: userData, token, loading: false });
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`;
      return userData;
    } catch (error) {
      const errorMessage = error.response?.data?.message || 'Error en la autenticación';
      set({ error: errorMessage, loading: false });
      throw new Error(errorMessage);
    }
  },

  register: async (data) => {
    set({ loading: true, error: null });
    try {
      const response = await axios.post(`${process.env.REACT_APP_API_URL}/api/auth/register`, data);
      set({ user: response.data, loading: false });
      return response.data;
    } catch (error) {
      const errorMessage = error.response?.data?.message || 'Error en el registro';
      set({ error: errorMessage, loading: false });
      throw new Error(errorMessage);
    }
  },

  logout: () => {
    localStorage.removeItem('token');
    delete axios.defaults.headers.common['Authorization'];
    set({ user: null, token: null });
  },
}));

export default useUserStore;
