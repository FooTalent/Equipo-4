import { Link } from 'react-router-dom';
import CreateUser from './create-user';

export default function AdminDashboardDesktop() {
  return (
    <>
      <div className='hidden md:grid gap-6 py-4 items-center grid-rows-2 mx-auto w-full h-full max-w-6xl'>
        <div className='bg-white rounded-xl m-2 p-4 grid gap-5 h-full'>
          <div className='flex items-start gap-2'>
            <img src='/dashboard-admin/voluntariado-desktop.svg' alt='Voluntariado y Seguimiento' />
            <h2 className='pt-2 text-xl'>Voluntariado y Seguimiento</h2>
          </div>
          <div className='grid grid-cols-3 gap-4'>
            <Link to={'/admin/solicitud-mentorias'} className='p-6 h-56 grid items-center bg-emerald-100 rounded-lg'>
              <img src='/dashboard-admin/familia-mentorias-desktop.svg' alt='Familias que solicitan mentorías' className='self-center' />
              <p className='self-start text-lg'>Familias que solicitan mentorías</p>
            </Link>
            <Link to={'/admin/familias-voluntarias'} className='p-6 h-56 grid items-center bg-orange-100 rounded-lg'>
              <img src='/dashboard-admin/gestion-familia-desktop.svg' alt='Gestión de familias voluntarias' className='self-center' />
              <p className='self-start text-lg'>Gestión de familias voluntarias</p>
            </Link>
            <Link to={'/admin/seguimiento-familias'} className='p-6 h-56 grid items-center bg-red-100 rounded-lg'>
              <img src='/dashboard-admin/seguimiento-familia-desktop.svg' alt='Seguimiento de familias' className='self-center' />
              <p className='self-start text-lg'>Seguimiento de familias</p>
            </Link>
          </div>
        </div>
        <div className='bg-white rounded-xl m-2 p-4 grid gap-5 h-full'>
          <div className='flex items-start gap-2'>
            <img src='/dashboard-admin/base-datos-desktop.svg' alt='Base de Datos General' className='w-12' />
            <h2 className='pt-2 text-xl'>Base de Datos General</h2>
          </div>
          <div className='grid grid-cols-3 gap-4'>
            <Link to={'/admin/listado-familias'} className='p-6 h-56 grid items-center bg-emerald-100 rounded-lg'>
              <img src='/dashboard-admin/listado-familia-desktop.svg' alt='Listado de familias' className='self-center' />
              <p className='self-start text-lg'>Listado de familias</p>
            </Link>
            {/* <div className='p-6 h-56 grid items-center bg-orange-100 rounded-lg'>
              <img src='/dashboard-admin/crear-usuario-desktop.svg' alt='Creare nuevo usuario' className='self-center' />
              <p className='self-start text-lg'>Crear nuevo usuario</p>
            </div> */}
            <CreateUser />
            <Link to={'/admin/email-general'} className='p-6 h-56 grid items-center bg-red-100 rounded-lg'>
              <img src='/dashboard-admin/email-general-desktop.svg' alt='email general' className='self-center' />
              <p className='self-start text-lg'>E-mail general</p>
            </Link>
          </div>
        </div>
      </div>
    </>
  );
}