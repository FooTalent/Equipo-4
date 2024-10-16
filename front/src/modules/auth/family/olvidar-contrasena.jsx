import { Link, useNavigate } from 'react-router-dom';
import { MdArrowBackIosNew } from 'react-icons/md';
import { Input } from '/src/components/ui/input';
import { Label } from '/src/components/ui/label';
import { Button } from '/src/components/ui/button';
import { Form } from '@/components/ui';
import { useForm } from 'react-hook-form';
import * as yup from 'yup';
import { yupResolver } from '@hookform/resolvers/yup';
import useAuthStore from '@/store/user';
import { useEffect } from 'react';
import { useMutation } from '@tanstack/react-query';
import { forgotPasswordFamilyApi } from './api/familyAuthApi';
import { toast } from 'react-toastify';
import Spinner from '@/components/ui/spinner';

const FamilyForgotPassword = () => {
  const user = useAuthStore((state) => state.user);
  const navigate = useNavigate();
  const schema = yup.object({
    email:
    yup.string('Introduce un email valido')
      .required('Introduce un email valido')
      .email('Introduce un email valido'),
  });
  const form = useForm({
    resolver: yupResolver(schema),
    defaultValues: {
      email: '',
    }
  });
  useEffect(() => {
    if (user) {
      if (user.tipoUsuario === 'ADMIN') {
        if (user.primerIngreso === 'false') {
          navigate('/admin/dashboard');
        }
      }
    }
  }, [user, navigate]);
  const mutation = useMutation({
    mutationFn: forgotPasswordFamilyApi,
    onSuccess: (data) => {
      if (data) {
        toast.success(data);
      } else {
        toast.error(data);
      }
    },
    onError: () => {
      toast.error('Ha ocurrido un error');
    },
  });
  const onSubmit = async(data) => {
    mutation.mutate({ email: data.email });
  };
  return (
    <div className='relative md:bg-grayDefault py-8 h-screen grid md:flex md:flex-col md:gap-12 items-center px-4'>
      <Link className='block md:hidden absolute z-30 top-8 left-4' to={'/auth/ingresar'}><MdArrowBackIosNew /></Link>
      <Link to={'/auth/ingresar'} className='hidden md:block top-4 left-4 w-full'>
        <img src='/common/logo-phrase.svg' alt='family one' className=''/>
      </Link>
      <div className='max-w-md w-full space-y-8 bg-white md:h-3/4 md:shadow-lg  md:mx-auto md:w-full md:p-5 md:rounded-xl'>
        <div className='flex flex-col gap-4'>
          <h2 className='mt-6 text-3xl text-gray-900'>
            Recuperar contraseña
          </h2>
          <p>Introduce tu Email y te enviaremos un correo electrónico con instrucciones para recuperar tu contraseña</p>
        </div>
        <Form {...form} className='border-0 outline-none '>
          <form onSubmit={form.handleSubmit(onSubmit)}  className='mt-8 space-y-6 grid h-96'>
            <div className=''>
              <div className='mb-4 flex flex-col gap-3'>
                <Label htmlFor='correo'>
                Email
                </Label>
                <Input
                  id='email'
                  name='email'
                  type='text'
                  className='outline-none'
                  placeholder='Escribe tu Email'
                  {...form.register('email', { required: true })}
                />
                {form.formState.errors && <p className='text-red-500 text-sm'>{form?.formState?.errors?.email?.message}</p>}
              </div>

            </div>

            <div className='flex flex-col gap-4 justify-end'>
              <Button
                type='submit'
                variant='default'
                className='w-full mt-4 md:mt-0 py-6 bg-white text-orange-400 border-2 border-orange-400 hover:bg-orange-50 hover:border-orange-200'
              >
                {mutation.isPending ? <Spinner /> : 'Enviar'}
              </Button>
              <Link
                to={'/auth/ingresar'}
                variant='default'
                className='bg-orange-400 hover:bg-orange-500 py-3 rounded text-center'
              >
                volver
              </Link>
            </div>
          </form>
        </Form>
      </div>
    </div>
  );
};

export default FamilyForgotPassword;
