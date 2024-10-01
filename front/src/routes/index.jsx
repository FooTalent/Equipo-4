import App from '@/App';
import Admin from '@/modules/auth/admin/page';
import UserType from '@/modules/auth/components/user-type';
import Family from '@/modules/auth/family/page';
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
  },
  {
    path: '/auth/admin/personalize', 
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
