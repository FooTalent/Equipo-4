import useAuthStore from '@/store/user';
import { Link, useNavigate } from 'react-router-dom';
import {
  Dialog,
  DialogTrigger,
  Button,
  DialogContent,
  DialogClose,
  DialogFooter
} from '../ui';
import { useState } from 'react';

export default function Navbar() {
  const [isOpen, setIsOpen] = useState(false);
  const navigate = useNavigate();
  const user = useAuthStore((state) => state.user);
  const logout = useAuthStore((state) => state.logout);
  const onLogout = () => {
    logout();
    navigate('/auth');
  };
  const handleDialogChange = (open) => {
    setIsOpen(open);
  };
  return (
    <nav className='bg-orangeLight '>
      <section className='max-w-6xl mx-auto flex justify-between items-center px-3 py-3'>
        <Link to={`${user?.tipoUsuario === 'ADMIN' ? '/admin/dashboard' : ''}`}>
          <img src='/common/logo-inapp.svg' alt='family one' className='w-9 block md:hidden' />
          <img src='/common/logo-desktop.svg' alt='family one' className=' hidden md:block' />
        </Link>
        <div className='flex items-center gap-6'>
          <Link to={`${user?.tipoUsuario === 'ADMIN' ? '/admin/notificacion' : ''}`} className='hidden md:flex flex-col items-center gap-1'>
            <img src='/dashboard-admin/notification-desktop.svg' alt='notificación' className='w-6 mx-auto' />
            <p>Notificación</p>
          </Link>
          <Link to={`${user?.tipoUsuario === 'ADMIN' ? '/admin/perfil' : ''}`} className='hidden md:flex flex-col items-center gap-1'>
            <img src='/common/perfil.svg' alt='perfil' className='w-7 mx-auto' />
            <p>Perfil</p>
          </Link>
          <Dialog open={isOpen} onOpenChange={handleDialogChange}>
            <DialogTrigger asChild>
              <button>
                <img src='/common/logout.svg' alt='cerrar sesion' className='w-6 mx-auto' />
                <p className=''>Cerrar sesión</p>
              </button>
            </DialogTrigger>
            <DialogContent className='md:max-w-[450px] py-8 border-0 rounded-2xl w-[95%] mx-auto bg-gray-300'>
              <div className='text-lg text-center font-semibold'>
                <p>Estas por cerrar tu sesión</p>
                <p>¿Estas seguro que deseas continuar?</p>
              </div>
              <DialogFooter className='flex w-full gap-2'>
                <DialogClose className={'w-full rounded-md text-white bg-green focus:bg-white hover:bg-greenHover focus:text-green focus:border focus:border-green'}>Cancelar</DialogClose>
                <Button type='submit' onClick={onLogout} variant='red' className='py-6 w-full'>Cerrar Sesión</Button>
              </DialogFooter>
            </DialogContent>
          </Dialog>
        </div>
      </section>
    </nav>
  );
}