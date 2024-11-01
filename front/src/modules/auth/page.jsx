import useAuthStore from '@/store/user';
import { Link } from 'react-router-dom';
import { useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import { Button } from '@/components/ui';

export default function Auth() {
  const user = useAuthStore((state) => state.user);
  const navigate = useNavigate();
  useEffect(() => {
    if (user && user.primerIngreso === 'true')
    {
      if (user.tipoUsuario === 'ADMIN') navigate('auth/admin/personalizar');
      if (user.tipoUsuario !== 'ADMIN') navigate('auth/familia/personalizar');
    }
  }, [user, navigate]);
  return (
    <main className='h-screen grid lg:grid-cols-2 py-[2%] px-2 md:px-0 text-center xl:max-w-6xl xl:mx-auto'>
      <section className='h-full flex flex-col md:p-4'>
        <div className='flex flex-col gap-16 md:gap-8 justify-center text-left h-full w-full'>
          <img src='/common/afac-logo.svg' alt='AFAC' className='max-w-32'/>
          <h1 className='text-4xl md:text-5xl font-extralight'>
        Bienvenido al <br /> Sistema de Gestión <br /> de Datos de <span className=''>AFAC</span>
          </h1>
          <Link to={'/auth/ingresar'} className=''>
            <Button variant={'orange'} className='w-full md:w-3/4 py-6 text-center rounded-md'>Continuar</Button>
          </Link>
        </div>
        <div className='pb-10 md:pb-0'>
          <img src='/common/logo-fondo-claro.svg' alt='family one' className=' max-w-48'/>
        </div>
      </section>
      <section className='hidden lg:block relative'>
        <img src='/auth/welcome-desktop.svg' alt='una familia feliz' className='relative max-w-[500px]' />
        <img src='/auth/Rectangle-auth-screens.svg' alt='' className=' absolute top-8 -left-5 max-w-[495px]'/>
      </section>
    </main>
  );
}