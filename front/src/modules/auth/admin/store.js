import { create } from 'zustand';
import axios from 'axios';

const useUserStore = create((set) => ({
  user: null,
  loading: false,
  error: null,

  // Función para iniciar sesión
  login: async (credentials) => {
    set({ loading: true, error: null });
    try {
      const response = await axios.post('/api/login', credentials);
      set({ user: response.data, loading: false });
    } catch (error) {
      set({ error: error.response?.data?.message || 'Error en la autenticación', loading: false });
    }
  },

  // Función para registrar o cambiar credenciales
  register: async (data) => {
    set({ loading: true, error: null });
    try {
      const response = await axios.post('/api/register', data);
      set({ user: response.data, loading: false });
    } catch (error) {
      set({ error: error.response?.data?.message || 'Error en el registro', loading: false });
    }
  },

  // Función para resetear el estado
  logout: () => set({ user: null }),
}));

export default useUserStore;
