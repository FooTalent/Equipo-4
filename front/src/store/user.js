import { create } from 'zustand';
import { persist } from 'zustand/middleware';

const useAuthStore = create(
  persist(
    (set) => ({
      user: null,
      setUser: (userData) => set({ user: userData }),
      setFirstLogin: (value) => set((state) => ({
        user: state.user ? { ...state.user, primerIngreso: value } : null
      })),
      logout: () => set({ user: null }),
    }),
    {
      name: 'user-data',
    }
  )
);

export default useAuthStore;
