import {
  Form,
  FormField,
  FormItem,
  FormLabel,
  FormControl,
  RadioGroup,
  RadioGroupItem,
  Button } from '@/components/ui/index';
import { useForm } from 'react-hook-form';
import * as yup from 'yup';
import { yupResolver } from '@hookform/resolvers/yup';
import { MdArrowBackIosNew } from 'react-icons/md';
import { Link, useNavigate } from 'react-router-dom';

export default function UserType() {
  const schema = yup.object({
    type: yup.string('Selecciona una opción').required('Selecciona una opción')
  });
  const form = useForm({
    resolver: yupResolver(schema)
  });
  const navigate = useNavigate();
  const onSubmit = (data) => {
    if (data.type  === 'administrador') {
      navigate('/auth/admin/ingresar');
    } else if (data.type === 'familia') {
      navigate('/auth/familia/ingresar');
    }
  };
  return (
    <main className='relative py-8 h-screen grid items-center px-4 text-center'>
      <Link className='absolute z-30 top-8 left-4' to={'/auth'}><MdArrowBackIosNew/></Link>
      <Form {...form}>
        <form onSubmit={form.handleSubmit(onSubmit)} className='md:max-w-md md:mx-auto md:w-full space-y-8 relative grid items-center h-full'>
          <FormField
            control={form.control}
            name='type'
            render={({ field }) => (
              <FormItem className='h-full flex flex-col justify-end md:items-center md:text-left gap-4 text-left'>
                <FormLabel className='text-lg md:text-2xl'>Selecciona una opción:</FormLabel>
                <FormControl>
                  <RadioGroup {...field} className='md:-ml-2'>
                    <FormItem className='flex items-center space-x-2 space-y-0 mb-2'>
                      <FormControl>
                        <RadioGroupItem value='administrador' />
                      </FormControl>
                      <FormLabel className='text-sm md:font-light md:text-lg'>
                      Administrador
                      </FormLabel>
                    </FormItem>
                    <FormItem className='flex items-center space-x-2 space-y-0'>
                      <FormControl>
                        <RadioGroupItem value='familia' />
                      </FormControl>
                      <FormLabel className='text-sm md:font-light md:text-lg'>
                      Representante de Familia
                      </FormLabel>
                    </FormItem>
                  </RadioGroup>
                </FormControl>
              </FormItem>
            )}
          />
          <Button type='submit' className='self-end md:self-start py-6 text-base'>Continuar</Button>
        </form>
      </Form>
    </main>
  );
}