import App from '@/App';
import Admin from '@/modules/auth/admin/page';
import UserType from '@/modules/auth/components/user-type';
import Family from '@/modules/auth/family/page';
import Auth from '@/modules/auth/page';
import { createBrowserRouter, RouterProvider } from 'react-router-dom';

const router = createBrowserRouter([
  {
    path: '/',
    element: <App />
  },
  {
    path: '/auth',
    element: <Auth />
  },
  {
    path: '/auth/usuario',
    element: <UserType />
  },
  {
    path: '/auth/administrador',
    element: <Admin />
  },
  {
    path: '/auth/familia',
    element: <Family />
  }
]);

export default function Router() {
  return <RouterProvider router={router} fallbackElement={<p>Cargando...</p>} />;
}
