import useAuthStore from '@/store/user';
import { Link } from 'react-router-dom';

export default function Footer() {
  const user = useAuthStore((state) => state.user);
  return (
    <footer className='bg-orangeLight flex md:hidden justify-between items-center px-3 py-3'>
      <div className={`flex flex-col items-center ${user && user.tipoUsuario !== 'ADMIN' ? 'mx-auto' : ''}`}>
        <img src='/common/home.svg' alt='pagina principal' />
        <p>Inicio</p>
      </div>
      {user && user.tipoUsuario === 'ADMIN' && <>
        <div className=' flex flex-col items-center'>
          <img src='/common/email.svg' alt='correos' />
          <p>E-Mail</p>
        </div>
      </>}
      {user && user.tipoUsuario === 'ADMIN' && <>
        <Link to={`${user?.tipoUsuario === 'ADMIN' ? '/admin/notificacion' : ''}`} className=' flex flex-col items-center'>
          <img src='/common/email.svg' alt='notificación' />
          <p>Notificación</p>
        </Link>
      </>}
      {user && user.tipoUsuario === 'ADMIN' && <>
        <Link to={`${user?.tipoUsuario === 'ADMIN' ? '/admin/perfil' : ''}`} className=' flex flex-col items-center'>
          <img src='/common/perfil.svg' alt='perfil' />
          <p>Perfil</p>
        </Link>
      </>}
    </footer>
  );
}