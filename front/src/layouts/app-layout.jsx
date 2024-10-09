import Navbar from '@/components/shared/navbar';
import Footer from '@/components/shared/footer';
import useAuthStore from '@/store/user';
import { useEffect } from 'react';
import { useNavigate } from 'react-router-dom';

export const AppLayout = ({ children }) => {
  const navigate = useNavigate();
  const user = useAuthStore((state) => state.user);
  useEffect(() => {
    if (!user) navigate('/auth');
    if (user && user.primerIngreso === 'true') {
      if (user.tipoUsuario === 'ADMIN') navigate('/auth/admin/personalizar');
      if (user.tipoUsuario !== 'ADMIN') navigate('/auth/familia/personalizar');
    }
  }, [user, navigate]);
  return (
    <>
      <section className='w-full flex flex-col gap-y-4 md:gap-y-0 h-screen'>
        <Navbar />
        {children}
        <Footer />
      </section>
    </>
  );
};
