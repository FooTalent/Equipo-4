
export default function AdminDashboardMobile() {
  return (
    <>
      <div className='grid grid-rows-2 md:hidden rounded-xl shadow-lg mx-2 h-full'>
        <div className='bg-orange-200 flex rounded-t-lg items-center p-2'>
          <img src='/dashboard-admin/voluntariado-mobile.svg' alt='voluntariado y seguimiento' className='px-6' />
        </div>
        <div className='flex items-center'>
          <p className='px-6 font-medium text-2xl'>Voluntariado y Seguimiento</p>
        </div>
      </div>
      <div className='grid grid-rows-2 md:hidden rounded-xl shadow-lg mx-2 h-full'>
        <div className='bg-emerald-100 flex rounded-t-lg items-center p-2'>
          <img src='/dashboard-admin/base-datos-mobile.svg' alt='voluntariado y seguimiento' className='px-6' />
        </div>
        <div className='flex items-center'>
          <p className='px-6 font-medium text-2xl'>Base de Datos General</p>
        </div>
      </div>
    </>
  );
}