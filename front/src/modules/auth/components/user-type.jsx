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
      navigate('/auth/administrador');
    } else if (data.type === 'familia') {
      navigate('/auth/familia');
    }
  };
  return (
    <main className='relative py-8 h-screen grid items-center px-4 text-center'>
      <Link className='absolute z-30 top-8 left-4' to={'/auth'}><MdArrowBackIosNew/></Link>
      <Form {...form}>
        <form onSubmit={form.handleSubmit(onSubmit)} className='relative grid items-center h-full'>
          <FormField
            control={form.control}
            name='type'
            render={({ field }) => (
              <FormItem className='h-full flex flex-col justify-end gap-4 text-left'>
                <FormLabel>Selecciona una opción:</FormLabel>
                <FormControl>
                  <RadioGroup {...field}>
                    <FormItem className='flex items-center space-x-2 space-y-0 mb-2'>
                      <FormControl>
                        <RadioGroupItem value='administrador' />
                      </FormControl>
                      <FormLabel className='font-normal'>
                      Administrador
                      </FormLabel>
                    </FormItem>
                    <FormItem className='flex items-center space-x-2 space-y-0'>
                      <FormControl>
                        <RadioGroupItem value='familia' />
                      </FormControl>
                      <FormLabel className='font-normal'>
                      Representante de Familia
                      </FormLabel>
                    </FormItem>
                  </RadioGroup>
                </FormControl>
              </FormItem>
            )}
          />
          <Button type='submit' className='self-end py-6 text-base'>Continuar</Button>
        </form>
      </Form>
    </main>
  );
}