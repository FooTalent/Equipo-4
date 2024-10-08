import { Input } from '@/components/ui';
import { AppLayout } from '@/layouts/app-layout';
import { useNavigate } from 'react-router-dom';

export default function RequestMentoring() {
  const navigate = useNavigate();
  return (
    <AppLayout>
      <section className='h-full md:bg-gray-100 md:grid md:items-center'>
        <div className='p-0 grid md:flex md:flex-col gap-16 md:gap-12 max-w-6xl mx-auto px-2 md:px-4 md:py-4 md:h-3/4 md:bg-white md:w-[650px] md:rounded-lg md:border-0 md:mx-auto'>
          <div className='flex md:flex-col gap-2 md:gap-5'>
            <img onClick={() => navigate('/admin/dashboard')} src='/common/arrow-left.svg' alt='Regresar a la página principal' className='self-start pt-2 md:pt-0 hover:cursor-pointer' />
            <p className='self-center -mb-2 md:-mb-0 text-2xl md:w-full'>Solicitud de Mentorias</p>
          </div>
          <div className='flex flex-col gap-3'>
            <div>
              <Input
                className='border-orange-300 focus-visible:ring-0 focus-visible:ring-offset-0 placeholder:text-gray-400'
                placeholder='Nombre y Apellido'
                disabled
              />
            </div>
            <div>
              <Input
                className='border-orange-300 focus-visible:ring-0 focus-visible:ring-offset-0 placeholder:text-gray-400'
                placeholder='Nombre y Apellido'
                disabled
              />
            </div>
            <div>
              <Input
                className='border-orange-300 focus-visible:ring-0 focus-visible:ring-offset-0 placeholder:text-gray-400'
                placeholder='Nombre y Apellido'
                disabled
              />
            </div>
            <div>
              <Input
                className='border-orange-300 focus-visible:ring-0 focus-visible:ring-offset-0 placeholder:text-gray-400'
                placeholder='Nombre y Apellido'
                disabled
              />
            </div>
            <div>
              <Input
                className='border-orange-300 focus-visible:ring-0 focus-visible:ring-offset-0 placeholder:text-gray-400'
                placeholder='Nombre y Apellido'
                disabled
              />
            </div>
          </div>
        </div>
      </section>
    </AppLayout>
  );
}