import { useState, useEffect } from 'react';
import { useForm } from 'react-hook-form';
import { useNavigate } from 'react-router-dom';
import { Link } from 'react-router-dom';
import { MdArrowBackIosNew } from 'react-icons/md';
import { Input } from '/src/components/ui/input';
import { Label } from '/src/components/ui/label';
import { Button } from '/src/components/ui/button';
import { Form } from '@/components/ui';
import * as yup from 'yup';
import { yupResolver } from '@hookform/resolvers/yup';
import { IoIosEyeOff, IoIosEye } from 'react-icons/io';
import Spinner from '@/components/ui/spinner';
import { useMutation } from '@tanstack/react-query';
import { loginApi } from './api';
import { toast } from 'react-toastify';
import useAuthStore from '@/store/user';

const Login = () => {
  const user = useAuthStore((state) => state.user);
  const setUser = useAuthStore((state) => state.setUser);
  const schema = yup.object({
    correo:
    yup.string('Introduce un correo valido')
      .required('Introduce un correo valido')
      .email('Introduce un correo valido'),
    contrasenaHash:
    yup.string('Introduce contraseña valida')
      .required('Introduce contraseña valida')
      .min(8, 'Una contraseña tiene que tener un minimo de 8 caracteres')
      .max(35, 'Una contraseña no puede tener que tener más que 35 caracteres')
      .matches(
        /^(?=.*[A-Za-z])(?=.*\d)(?=.*[^A-Za-z\d\s])[A-Za-z\d@$!%*#?&_/]{8,}$/,
        'La contraseña debe contener al menos una letra, un número y un carácter especial')
  });
  const form = useForm({
    resolver: yupResolver(schema),
    defaultValues: {
      correo: '',
      contrasenaHash: ''
    }
  });
  const navigate = useNavigate();
  const [showPassword, setShowPassword] = useState(false);
  useEffect(() => {
    if (user) {
      if (user.tipoUsuario === 'ADMIN') {
        if (user.primerIngreso === 'true') {
          navigate('/auth/admin/personalizar');
        } else {
          navigate('/admin/dashboard');
        }
      } else {
        navigate('/');
      }
      if (user.tipoUsuario !== 'ADMIN') {
        if (user.primerIngreso === 'true') {
          navigate('/auth/familia/personalizar');
        } else {
          navigate('/familia');
        }
      }
    }
  }, [user, navigate]);
  const mutation = useMutation({
    mutationFn: loginApi,
    onSuccess: (data) => {
      if (data.correo) {
        setUser(data);
        toast.success('Inicio de sesión exitoso');
        if (data.tipoUsuario === 'ADMIN' && data.primerIngreso === 'true')
        {
          navigate('/auth/admin/personalizar');
        } else if (data.tipoUsuario === 'ADMIN' && data.primerIngreso === 'false') {
          navigate('/admin/dashboard');
        } else if (data.tipoUsuario !== 'ADMIN' && data.primerIngreso === 'true')
        {
          navigate('/auth/familia/personalizar');
        } else {
          navigate('/familia');
        }
      } else {
        toast.error(data);
      }
    },
    onError: () => {
      toast.error('Ha ocurrido un error');
    },
  });
  const onSubmit = async (data) => {
    mutation.mutate(data);
  };
  return (
    <div className='h-screen grid lg:grid-cols-2 py-12 px-2 lg:px-0 text-center xl:max-w-6xl xl:mx-auto'>
      <Link className='block md:hidden absolute z-30 top-8 left-4' to={'/auth'}><MdArrowBackIosNew /></Link>
      <div className='relative'>
        <div className='h-full w-full lg:max-w-lg lg:mx-0 space-y-8 bg-white'>
          <div className='pt-[25%] md:pt-[15%] lg:pt-[25%]'>
            <Link className='hidden md:block' to={'/auth'}><MdArrowBackIosNew /></Link>
            <h2 className='mt-10 text-left text-3xl text-gray-900'>
            Inicio de sesión
            </h2>
          </div>
          <Form {...form} className='border-0 outline-none '>
            <form className='mt-8 space-y-6' onSubmit={form.handleSubmit(onSubmit)}>
              <div className='-space-y-px flex flex-col gap-3 text-left'>
                <div className='mb-4 flex flex-col gap-3'>
                  <Label htmlFor='correo'>
                Correo
                  </Label>
                  <Input
                    id='correo'
                    name='correo'
                    type='text'
                    className=' outline-none'
                    placeholder='Escribe tu correo electrónico'
                    {...form.register('correo', { required: true })}
                  />
                  {form.formState.errors && <p className='text-red-500 text-sm'>{form?.formState?.errors?.correo?.message}</p>}
                </div>
                <div className='mt-4 flex flex-col gap-3 relative'>
                  <Label htmlFor='contrasenaHash'>Contraseña</Label>
                  <IoIosEyeOff
                    onClick={() => setShowPassword(!showPassword)}
                    className={`${
                      !showPassword ? 'block' : 'hidden'
                    } absolute text-gray right-0 top-[36.6px] mr-2 hover:cursor-pointer`}
                  />
                  <IoIosEye
                    onClick={() => setShowPassword(!showPassword)}
                    className={`${
                      showPassword ? 'block' : 'hidden'
                    } absolute text-gray right-0 top-[36.6px] mr-2 hover:cursor-pointer`}
                  />
                  <Input
                    id='contrasenaHash'
                    name='contrasenaHash'
                    type={showPassword ? 'text' : 'password'}
                    placeholder='Escribe tu contraseña'
                    {...form.register('contrasenaHash', { required: true })}
                  />
                  {form.formState.errors && <p className='text-red-500 text-sm'>{form?.formState?.errors?.contrasenaHash?.message}</p>}
                </div>
              </div>
              <div className='text-center text-sm'>
                <Link to={'/auth/olvidar-contrasena'}
                  className=''>
                ¿Necesitas recuperar la contraseña?
                </Link>
              </div>
              <div>
                <Button
                  type='submit'
                  disabled={mutation.isPending}
                  variant='orange'
                  className='w-full mt-4 md:mt-0 py-6'
                >
                  {mutation.isPending ? <Spinner /> : 'Iniciar Sesión'}
                </Button>
              </div>
            </form>
          </Form>
        </div>
        <div className='hidden lg:block lg:-mt-14'>
          <img src='/common/logo-fondo-claro.svg' alt='family one' className=' max-w-48'/>
        </div>
      </div>
      <section className='hidden lg:flex relative justify-end'>
        <img src='/auth/login-photo.svg' alt='una familia feliz' className='relative max-w-[500px]' />
        <img src='/auth/Rectangle-auth-screens.svg' alt='' className='absolute top-8 left-0 max-w-[495px]'/>
      </section>
    </div>
  );
};

export default Login;
