import { AppLayout } from '@/layouts/app-layout';
import AdminDashboardMobile from './components/admin-dashboard-mobile';
import AdminDashboardDesktop from './components/admin-dashboard-desktop';
import { useEffect } from 'react';
import useAuthStore from '@/store/user';
import { useNavigate } from 'react-router-dom';

export default function AdminDashboard() {
  const navigate = useNavigate();
  const user = useAuthStore((state) => state.user);
  useEffect(() => {
    if (!user) navigate('auth');
    if (user.tipoUsuario !== 'ADMIN') {
      if (user.primerIngreso === 'true') {
        navigate('/auth/familia/personalizar');
      } else {
        navigate('/familia');
      }
    }
  }, [user, navigate]);
  return (
    <AppLayout>
      <section className='h-full p-0 grid gap-5 md:bg-grayDefault'>
        <AdminDashboardMobile />
        <AdminDashboardDesktop />
      </section>
    </AppLayout>
  );
}