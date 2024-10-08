import { Input } from '@/components/ui';
import { AppLayout } from '@/layouts/app-layout';
import { useNavigate } from 'react-router-dom';

export default function ListFamilies () {
  const navigate = useNavigate();
  return (
    <AppLayout>
      <section className='h-full md:bg-gray-100 md:grid md:items-center'>
        <div className='p-0 grid md:flex md:flex-col gap-6 max-w-6xl mx-auto px-2 md:px-4 md:py-4 md:h-3/4 md:bg-white md:w-[650px] md:rounded-lg md:border-0 md:mx-auto'>
          <div className='flex flex-col gap-4'>
            <div className='flex md:flex-col gap-2 md:gap-5'>
              <img onClick={() => navigate('/admin/dashboard')} src='/common/arrow-left.svg' alt='Regresar a la página principal' className='self-start pt-2 md:pt-0 hover:cursor-pointer' />
              <p className='self-center -mb-2 md:-mb-0 text-2xl md:w-full'>Listado de Familias</p>
            </div>
          </div>
          <div className='flex flex-col gap-3'>
            <div className='relative'>
              <Input
                className='border-gray-400 focus-visible:ring-0 focus-visible:ring-offset-0 placeholder:text-gray-400'
                placeholder='Nombre y Apellido'
                disabled
              />
              <img src='/dashboard-admin/delete.svg' alt='borar' className='absolute top-2 right-2' />
              <img src='/common/edit-input-field.svg' alt='editar' className='absolute top-[9.5px] right-10' />
            </div>
            <div className='relative'>
              <Input
                className='border-gray-400 focus-visible:ring-0 focus-visible:ring-offset-0 placeholder:text-gray-400'
                placeholder='Nombre y Apellido'
                disabled
              />
              <img src='/dashboard-admin/delete.svg' alt='borar' className='absolute top-2 right-2' />
              <img src='/common/edit-input-field.svg' alt='editar' className='absolute top-[9.5px] right-10' />
            </div>
            <div className='relative'>
              <Input
                className='border-gray-400 focus-visible:ring-0 focus-visible:ring-offset-0 placeholder:text-gray-400'
                placeholder='Nombre y Apellido'
                disabled
              />
              <img src='/dashboard-admin/delete.svg' alt='borar' className='absolute top-2 right-2' />
              <img src='/common/edit-input-field.svg' alt='editar' className='absolute top-[9.5px] right-10' />
            </div>
            <div className='relative'>
              <Input
                className='border-gray-400 focus-visible:ring-0 focus-visible:ring-offset-0 placeholder:text-gray-400'
                placeholder='Nombre y Apellido'
                disabled
              />
              <img src='/dashboard-admin/delete.svg' alt='borar' className='absolute top-2 right-2' />
              <img src='/common/edit-input-field.svg' alt='editar' className='absolute top-[9.5px] right-10' />
            </div>
            <div className='relative'>
              <Input
                className='border-gray-400 focus-visible:ring-0 focus-visible:ring-offset-0 placeholder:text-gray-400'
                placeholder='Nombre y Apellido'
                disabled
              />
              <img src='/dashboard-admin/delete.svg' alt='borar' className='absolute top-2 right-2' />
              <img src='/common/edit-input-field.svg' alt='editar' className='absolute top-[9.5px] right-10' />
            </div>
          </div>
        </div>
      </section>
    </AppLayout>
  );
}