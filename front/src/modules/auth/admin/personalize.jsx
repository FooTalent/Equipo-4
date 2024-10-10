import { useEffect, useState } from 'react';
import { useForm } from 'react-hook-form';
import { useNavigate } from 'react-router-dom';
import { Link } from 'react-router-dom';
import { MdArrowBackIosNew } from 'react-icons/md';
import { Label } from '@/components/ui/label';
import { Input } from '@/components/ui/input';
import { Button } from '@/components/ui/button';
import { Form } from '@/components/ui';
import * as yup from 'yup';
import { yupResolver } from '@hookform/resolvers/yup';
import { IoIosEyeOff, IoIosEye } from 'react-icons/io';
import useAuthStore from '@/store/user';
import { toast } from 'react-toastify';
import { useMutation } from '@tanstack/react-query';
import { personalizeAdminApi } from './api';
import Spinner from '@/components/ui/spinner';

const PersonalizeCredentialsAdmin = () => {
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
        /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&_])[A-Za-z\d@$!%*#?&_]{8,}$/,
        'La contraseña debe contener al menos una letra, un número y un carácter especial'),
    repiteContrasena: yup
      .string('Introduce tu contraseña de nuevo')
      .required('Tienes que introducer tu contraseña de nuevo')
      .oneOf([yup.ref('contrasenaHash')], 'La contraseña y la confirmación deben ser las mismas'),
  });
  const form = useForm({
    resolver: yupResolver(schema),
    defaultValues: {
      correo: '',
      contrasenaHash: '',
      repiteContrasena: ''
    }
  });
  const user = useAuthStore((state) => state.user);
  const logout = useAuthStore((state) => state.logout);
  const setFirstLogin = useAuthStore((state) => state.setFirstLogin);
  const navigate = useNavigate();
  const [showPassword, setShowPassword] = useState(false);
  const [showConfirmPassword, setShowConfirmPassword] = useState(false);
  useEffect(() => {
    if (user) {
      if (user.tipoUsuario === 'ADMIN') {
        if (user.primerIngreso === 'false') {
          navigate('/admin/dashboard');
        }
      } else {
        navigate('/');
      }
    }
    if (!user) navigate('/auth');
  }, [user, navigate]);
  const mutation = useMutation({
    mutationFn: personalizeAdminApi,
    onSuccess: (data) => {
      if (data === 'Contraseña actualizada exitosamente.') {
        setFirstLogin('false');
        toast.success(data);
        navigate('/admin/dashboard');
      } else {
        toast.error(data);
      }
    },
    onError: () => {
      toast.error('Ha ocurrido un error');
    },
  });
  const onSubmit = async (data) => {
    if (user.correo !== data.correo)
    {
      toast.error('Usa tu correo electrónico registrado');
    } else {
      mutation.mutate({ correo: data?.correo, contrasenaHash: data?.contrasenaHash });
    }
  };
  return (
    <div className='relative md:bg-cyan-50 py-8 h-screen grid md:flex md:flex-col md:gap-12 items-center px-4'>
      <Link className='block md:hidden absolute z-30 top-8 left-4' to={'/auth/tipo-usuario'}><MdArrowBackIosNew /></Link>
      <Link to={'/'} className='hidden md:block top-4 left-4 w-full'>
        <img src='/common/logo-phrase.svg' alt='family one' className=''/>
      </Link>
      <div className='max-w-md w-full space-y-8 bg-white md:h-3/4 md:shadow-lg  md:mx-auto md:w-full md:p-5 md:rounded-xl'>
        <div>
          <h2 className="mt-6 text-center text-3xl text-gray-900">
            Ahora, personaliza tus credenciales
          </h2>
        </div>
        <Form {...form}>
          <form className="mt-8 space-y-6" onSubmit={form.handleSubmit(onSubmit)}>
            <div className="rounded-md -space-y-px flex flex-col gap-4">
              <div className='flex flex-col gap-2'>
                <Label htmlFor='correo'>Correo</Label>
                <Input
                  id='correo'
                  name='correo'
                  type='text'
                  placeholder='Escribe tu correo electrónico'
                  {...form.register('correo', { required: true })}
                />
                {form.formState.errors && <p className="text-red-500 text-sm">{form?.formState?.errors?.correo?.message}</p>}
              </div>
              <div className='flex flex-col gap-2 relative'>
                <Label htmlFor='contrasenaHash'>Nueva contraseña</Label>
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
                  placeholder="Escribe tu nueva contraseña"
                  {...form.register('contrasenaHash', { required: true })}
                />
                {form.formState.errors && <p className="text-red-500 text-sm">{form?.formState?.errors?.contrasenaHash?.message}</p>}
              </div>
              <div className='flex flex-col gap-2 relative'>
                <Label htmlFor="confirmPassword">Repite contraseña</Label>
                <IoIosEyeOff
                  onClick={() => setShowConfirmPassword(!showConfirmPassword)}
                  className={`${
                    !showConfirmPassword ? 'block' : 'hidden'
                  } absolute text-gray right-0 top-[36.6px] mr-2 hover:cursor-pointer`}
                />
                <IoIosEye
                  onClick={() => setShowConfirmPassword(!showConfirmPassword)}
                  className={`${
                    showConfirmPassword ? 'block' : 'hidden'
                  } absolute text-gray right-0 top-[36.6px] mr-2 hover:cursor-pointer`}
                />
                <Input
                  id='repiteContrasena'
                  name='repiteContrasena'
                  type={showConfirmPassword ? 'text': 'password'}
                  placeholder="Repite tu nueva contraseña"
                  {...form.register('repiteContrasena', { required: true })}
                />
                {form.formState.errors && <p className="text-red-500 text-sm">{form?.formState?.errors?.repiteContrasena?.message}</p>}
                <button onClick={() => logout()} className='text-sm text-gray-400 font-semibold text-right'>¿Cerrar sesión?</button>
              </div>
            </div>
            <div>
              <Button
                type="submit"
                disabled={mutation.isPending}
                variant="default"
                className="w-full mt-4 py-6 bg-orange-400 hover:bg-orange-500"
              >
                {mutation.isPending ? <Spinner /> : 'Iniciar Sesión'}
              </Button>
            </div>
          </form>
        </Form>
      </div >
    </div >
  );
};

export default PersonalizeCredentialsAdmin;
