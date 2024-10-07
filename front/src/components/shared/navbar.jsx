
export default function Navbar() {
  return (
    <nav className='bg-orangeLight '>
      <section className='max-w-6xl mx-auto flex justify-between items-center px-3 py-3'>
        <div>
          <img src='/common/logo-inapp.svg' alt='family one' className='w-9 block md:hidden' />
          <img src='/common/logo-desktop.svg' alt='family one' className=' hidden md:block' />
        </div>
        <div className='flex items-center gap-6'>
          <div className='hidden md:flex flex-col items-center gap-1'>
            <img src='/dashboard-admin/notification-desktop.svg' alt='notificación' className='w-6 mx-auto' />
            <p>Notificación</p>
          </div>
          <div className='hidden md:flex flex-col items-center gap-1'>
            <img src='/common/perfil.svg' alt='perfil' className='w-7 mx-auto' />
            <p>Perfil</p>
          </div>
          <div className='flex flex-col md:gap-1'>
            <img src='/common/logout.svg' alt='cerrar sesion' className='w-6 mx-auto' />
            <p className=''>Cerrar sesión</p>
          </div>
        </div>
      </section>
    </nav>
  );
}