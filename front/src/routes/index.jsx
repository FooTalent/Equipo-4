import App from '@/App';
import AdminLogin from '@/modules/auth/admin/page';
import UserType from '@/modules/auth/components/user-type';
import Auth from '@/modules/auth/page';
import PersonalizeCredentialsAdmin from '@/modules/auth/admin/personalize';
import { createBrowserRouter, RouterProvider } from 'react-router-dom';
import FamilyLogin from '@/modules/auth/family/page';
import PersonalizeCredentialsFamily from '@/modules/auth/family/personalize';

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
    element: <PersonalizeCredentialsAdmin />
  },
  {
    path: '/auth/familia/ingresar',
    element: <FamilyLogin />
  },
  {
    path: '/auth/familia/personalizar',
    element: <PersonalizeCredentialsFamily />
  },
  {
    path: '*',
    element: <h1>Página no encontrada</h1>
  }
]);

export default function Router() {
  return <RouterProvider router={router} fallbackElement={<p>Cargando...</p>} />;
}
