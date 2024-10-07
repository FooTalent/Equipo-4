import { Form, Input } from '@/components/ui';
import { AppLayout } from '@/layouts/app-layout';
import { useForm } from 'react-hook-form';
import { useNavigate } from 'react-router-dom';

export default function AdminProfile() {
  const navigate = useNavigate();
  const form = useForm({
    defaultValues: {
      nombre: '',
      correo: '',
      cargo: ''
    }
  });
  return (
    <AppLayout>
      <section className='h-full md:bg-gray-100 md:grid md:items-center'>
        <div className='p-0 grid md:flex md:flex-col gap-16 md:gap-12 max-w-6xl mx-auto px-2 md:px-4 md:py-4 md:h-3/4 md:bg-white md:w-[650px] md:rounded-lg md:border-0 md:mx-auto'>
          <div className='flex md:flex-col gap-2 md:gap-5'>
            <img onClick={() => navigate('/admin/dashboard')} src='/common/arrow-left.svg' alt='Regresar a la página principal' className='self-start pt-2 md:pt-0 hover:cursor-pointer' />
            <p className='self-center -mb-2 md:-mb-0 text-2xl md:w-full'>Perfil Administrador</p>
          </div>
          <Form {...form}>
            <form className='flex flex-col gap-3'>
              <div className='relative'>
                <Input
                  className='border-orange-300 focus-visible:ring-0 focus-visible:ring-offset-0 placeholder:text-gray-400'
                  placeholder='Nombre y Apellido'
                  disabled
                  {...form.register('nombre', { required: false })}
                />
                <img src='/common/edit-input-field.svg' alt='actualiza el cargo' className='absolute top-2 right-2' />
              </div>
              <div className='relative'>
                <Input
                  className='border-orange-300 focus-visible:ring-0 focus-visible:ring-offset-0 placeholder:text-gray-400'
                  placeholder='Correo'
                  disabled
                  {...form.register('correo', { required: false })}
                />
                <img src='/common/edit-input-field.svg' alt='actualiza el cargo' className='absolute top-2 right-2' />
              </div>
              <div className='relative'>
                <Input
                  className='border-orange-300 focus-visible:ring-0 focus-visible:ring-offset-0 placeholder:text-gray-400'
                  placeholder='Cargo en AFAC'
                  disabled
                  {...form.register('cargo', { required: false })}
                />
                <img src='/common/edit-input-field.svg' alt='actualiza el cargo' className='absolute top-2 right-2' />
              </div>
            </form>
          </Form>
        </div>
      </section>
    </AppLayout>
  );
}