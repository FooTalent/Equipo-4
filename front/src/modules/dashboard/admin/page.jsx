import { AppLayout } from '@/layouts/app-layout';
import AdminDashboardMobile from './components/admin-dashboard-mobile';
import AdminDashboardDesktop from './components/admin-dashboard-desktop';

export default function AdminDashboard() {
  return (
    <AppLayout>
      <section className='h-full p-0 grid gap-5 md:bg-gray-100'>
        <AdminDashboardMobile />
        <AdminDashboardDesktop />
      </section>
    </AppLayout>
  );
}