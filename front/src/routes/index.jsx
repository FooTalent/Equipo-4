import App from '@/App';
import AdminLogin from '@/modules/auth/admin/page';
import UserType from '@/modules/auth/components/user-type';
import Auth from '@/modules/auth/page';
import PersonalizeCredentials from '@/modules/auth/admin/personalize';

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
    path: '/auth/tipo-usuario',
    element: <UserType />
  },
  {
    path: '/auth/admin/ingresar',
    element: <AdminLogin />
  },
  {
    path: '/auth/admin/personalizar',
    element: <PersonalizeCredentials />
  },
  {
    path: '*',
    element: <h1>Página no encontrada</h1>
  }
]);

export default function Router() {
  return <RouterProvider router={router} fallbackElement={<p>Cargando...</p>} />;
}
