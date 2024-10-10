import { useState } from 'react';
import { Link } from 'react-router-dom';
import CreateUser from './create-user';

export default function AdminDashboardMobile() {
  const [view, setView] = useState(0);
  return (
    <>
      <div onClick={() => setView(1)} className={`${view === 0 ? 'flex': 'hidden'} hover:cursor-pointer grid grid-rows-2 md:hidden rounded-xl shadow-lg mx-2 h-full`}>
        <div className='bg-orange-200 flex rounded-t-lg items-center p-2'>
          <img src='/dashboard-admin/voluntariado-mobile.svg' alt='voluntariado y seguimiento' className='px-6' />
        </div>
        <div className='flex items-center'>
          <p className='px-6 font-medium text-2xl'>Voluntariado y Seguimiento</p>
        </div>
      </div>
      <div onClick={() => setView(2)} className={`${view === 0 ? 'grid': 'hidden'} grid-rows-2 md:hidden rounded-xl shadow-lg mx-2 h-full hover:cursor-pointer`}>
        <div className='bg-emerald-100 flex rounded-t-lg items-center p-2'>
          <img src='/dashboard-admin/base-datos-mobile.svg' alt='voluntariado y seguimiento' className='px-6' />
        </div>
        <div className='flex items-center'>
          <p className='px-6 font-medium text-2xl'>Base de Datos General</p>
        </div>
      </div>
      <div className={`${view === 1 ? 'flex' : 'hidden'} md:hidden flex-col gap-6`}>
        <div className='flex gap-3'>
          <img onClick={() => setView(0)} src='/common/arrow-left.svg' alt='Regresar a la página principal' className='self-start pt-2 hover:cursor-pointer' />
          <p className='text-2xl'>Voluntariado y <br /> Seguimiento</p>
        </div>
        <div className='grid grid-rows-3 gap-4 px-2'>
          <Link to={'/admin/solicitud-mentorias'} className='p-6 h-44 grid items-center bg-emerald-100 rounded-lg'>
            <img src='/dashboard-admin/familia-mentorias-desktop.svg' alt='Familias que solicitan mentorías' className='self-center' />
            <p className='self-start text-lg'>Familias que solicitan mentorías</p>
          </Link>
          <Link to={'/admin/familias-voluntarias'} className='p-6 h-44 grid items-center bg-orange-100 rounded-lg'>
            <img src='/dashboard-admin/gestion-familia-desktop.svg' alt='Gestión de familias voluntarias' className='self-center' />
            <p className='self-start text-lg'>Gestión de familias voluntarias</p>
          </Link>
          <Link to={'/admin/seguimiento-familias'} className='p-6 h-44 grid items-center bg-red-100 rounded-lg'>
            <img src='/dashboard-admin/seguimiento-familia-desktop.svg' alt='Seguimiento de familias' className='self-center' />
            <p className='self-start text-lg'>Seguimiento de familias</p>
          </Link>
        </div>
      </div>
      <div className={`${view === 2 ? 'flex' : 'hidden'} md:hidden flex-col gap-6`}>
        <div className='flex gap-3'>
          <img onClick={() => setView(0)} src='/common/arrow-left.svg' alt='Regresar a la página principal' className='self-start pt-2 hover:cursor-pointer' />
          <p className='text-2xl'>Base de Datos General</p>
        </div>
        <div className='grid grid-rows-3 gap-4 px-2'>
          <Link to={'/admin/listado-familias'} className='p-6 h-44 grid items-center bg-emerald-100 rounded-lg'>
            <img src='/dashboard-admin/listado-familia-desktop.svg' alt='Listado de familias' className='self-center' />
            <p className='self-start text-lg'>Listado de familias</p>
          </Link>
          <CreateUser />
          <Link to={'/admin/email-general'} className='p-6 h-44 grid items-center bg-red-100 rounded-lg'>
            <img src='/dashboard-admin/email-general-desktop.svg' alt='email general' className='self-center' />
            <p className='self-start text-lg'>E-mail general</p>
          </Link>
        </div>
      </div>
    </>
  );
}