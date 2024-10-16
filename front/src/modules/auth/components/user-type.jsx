import {
  Form,
  FormField,
  FormItem,
  FormLabel,
  FormControl,
  RadioGroup,
  RadioGroupItem,
  Button
} from '@/components/ui/index';
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
    if (data.type === 'administrador') {
      navigate('/auth/admin/ingresar');
    } else if (data.type === 'familia') {
      navigate('/auth/familia/ingresar');
    }
  };

  return (
    <main className='relative md:bg-gray-300 py-8 h-screen grid md:flex md:flex-col md:gap-12 items-center px-4 text-center'>
      <Link className='block md:hidden absolute z-30 top-8 left-4' to={'/auth'}><MdArrowBackIosNew /></Link>
      <Link to={'/auth'} className='hidden md:block top-4 left-4 w-full'>
        <img src='/common/logo-phrase.svg' alt='family one' className=''/>
      </Link>
      <Form {...form}>
        <form onSubmit={form.handleSubmit(onSubmit)} className='md:max-w-md md:h-3/4 md:shadow-lg bg-white md:mx-auto md:w-full space-y-8 md:p-5 md:rounded-xl relative grid gap-10 items-center h-full'>
          <FormField
            control={form.control}
            name='type'
            render={({ field }) => (
              <FormItem className='h-full flex flex-col justify-end md:items-center md:text-left gap-8 text-left'>
                <FormLabel className='text-lg md:text-2xl'>Selecciona una opción:</FormLabel>
                <FormControl>
                  <RadioGroup onValueChange={field.onChange}
                    value={field.value}
                    className='md:-ml-2'>
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
          <Button type='submit' className='text-black self-end md:self-start py-4 text-base bg-orange-400 hover:bg-orange-500'>Continuar</Button>
        </form>
      </Form>
    </main>
  );
}