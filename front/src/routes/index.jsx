import App from '@/App';
import AdminLogin from '@/modules/auth/admin/page';
import UserType from '@/modules/auth/components/user-type';
import Auth from '@/modules/auth/page';
import PersonalizeCredentialsAdmin from '@/modules/auth/admin/personalize';
import { createBrowserRouter, RouterProvider } from 'react-router-dom';
import FamilyLogin from '@/modules/auth/family/page';
import PersonalizeCredentialsFamily from '@/modules/auth/family/personalize';
import Terminos from '@/modules/auth/family/terminos';
import ContratoConfidencialidad from '@/modules/auth/family/contrato-confidencialidad';
import AdminDashboard from '@/modules/dashboard/admin/page';
import AdminProfile from '@/modules/dashboard/admin/pages/profile';
import RequestMentoring from '@/modules/dashboard/admin/pages/request-mentoring';
import VolunteerFamilies from '@/modules/dashboard/admin/pages/volunteer-families';
import FollowUpFamilies from '@/modules/dashboard/admin/pages/follow-up-families';
import ListFamilies from '@/modules/dashboard/admin/pages/list-families';
import GeneralEmail from '@/modules/dashboard/admin/pages/general-email';
import CreateUser from '@/modules/dashboard/admin/components/create-user';
import FamilyForgotPassword from "@/modules/auth/family/olvidar-contrasena.jsx";
import FamilyResetPassword from "@/modules/auth/family/recuperar-contrasena.jsx";

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
    path: '/auth/familia/olvidar-contrasena',
    element: <FamilyForgotPassword />,
  },
  {
    path: '/auth/familia/recuperar-contrasena',
    element: <FamilyResetPassword />,
  },
  {
    path: '/auth/familia/personalizar',
    element: <PersonalizeCredentialsFamily />
  },
  {
    path: '/auth/familia/terminos',
    element: <Terminos />
  },
  {
    path: '/auth/familia/contrato-confidencialidad',
    element: <ContratoConfidencialidad />
  },
  {
    path: '/admin/dashboard',
    element: <AdminDashboard />
  },
  {
    path: '/admin/perfil',
    element: <AdminProfile />
  },
  {
    path: '/admin/solicitud-mentorias',
    element: <RequestMentoring />
  },
  {
    path: '/admin/familias-voluntarias',
    element: <VolunteerFamilies />
  },
  {
    path: '/admin/seguimiento-familias',
    element: <FollowUpFamilies />
  },
  {
    path: '/admin/listado-familias',
    element: <ListFamilies />
  },
  {
    path: '/admin/email-general',
    element: <GeneralEmail />
  },
  {
    path: '/admin/crear-usuario',
    element: <CreateUser />
  },
  {
    path: '*',
    element: <h1>Página no encontrada</h1>
  }
]);

export default function Router() {
  return <RouterProvider router={router} fallbackElement={<p>Cargando...</p>} />;
}
