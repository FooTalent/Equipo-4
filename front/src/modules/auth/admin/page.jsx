import { useState } from 'react';
import { useForm } from 'react-hook-form';
// import { useNavigate } from 'react-router-dom';
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
import { loginAdminApi } from './api';
import { toast } from 'react-toastify';
import useAuthStore from '@/store/user';

const AdminLogin = () => {
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
        /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&_])[A-Za-z\d@$!%*#?&_]{8,}$/,
        'La contraseña debe contener al menos una letra, un número y un carácter especial')
  });
  const form = useForm({
    resolver: yupResolver(schema),
    defaultValues: {
      correo: '',
      contrasenaHash: ''
    }
  });
  // const navigate = useNavigate();
  const [showPassword, setShowPassword] = useState(false);
  const mutation = useMutation({
    mutationFn: loginAdminApi,
    onSuccess: (data) => {
      if (data.correo) {
        setUser(data);
        toast.success('Inicio de sesión exitoso');
        //navigate('/');
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
    // navigate('/auth/admin/personalizar');
  };

  return (
    <div className='flex flex-col items-center justify-center min-h-screen p-4'>
      <Link className='absolute z-30 top-8 left-4' to={'/auth/tipo-usuario'}>
        <MdArrowBackIosNew />
      </Link>
      <div className='max-w-md w-full space-y-8'>
        <div>
          <h2 className='mt-6 text-3xl text-gray-900'>
            Ingresa las credenciales suministradas
          </h2>
        </div>
        <Form {...form} className='border-0 outline-none'>
          <form className='mt-8 space-y-6' onSubmit={form.handleSubmit(onSubmit)}>
            <div className='-space-y-px flex flex-col gap-3'>
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
                {form.formState.errors && <p className="text-red-500 text-sm">{form?.formState?.errors?.correo?.message}</p>}
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
                {form.formState.errors && <p className="text-red-500 text-sm">{form?.formState?.errors?.contrasenaHash?.message}</p>}
              </div>
            </div>

            <div>
              <Button
                type='submit'
                disabled={mutation.isPending}
                variant='default'
                className='text-black w-full mt-4 py-6 bg-orange-400 hover:bg-orange-500'
              >
                {mutation.isPending ? <Spinner /> : 'Iniciar Sesión'}
              </Button>
            </div>
          </form>
        </Form>
      </div>
    </div>
  );
};

export default AdminLogin;
