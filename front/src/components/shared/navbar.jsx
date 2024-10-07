
export default function Navbar() {
  return (
    <nav className='bg-[#FFBA69] flex justify-between items-center px-3 py-3'>
      <div>
        <img src='/common/logo-inapp.svg' alt='family one' className='w-9' />
      </div>
      <div className='flex flex-col'>
        <img src='/common/logout.svg' alt='cerrar sesion' className='w-6 mx-auto' />
        <p className=''>Cerrar sesión</p>
      </div>
    </nav>
  );
}