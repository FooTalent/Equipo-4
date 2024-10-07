import { defineConfig } from 'vite';
import react from '@vitejs/plugin-react-swc';
import path from 'path';

export default defineConfig({
  plugins: [react()],
  resolve: {
    alias: {
      // eslint-disable-next-line no-undef
      '@': path.resolve(__dirname, './src'),
    },
  },
  define: {
    // eslint-disable-next-line no-undef
    'import.meta.env.VITE_APP_API_URL': JSON.stringify(env.VERCEL_ENV),
  },
});
