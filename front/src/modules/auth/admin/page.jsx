import { useState } from 'react';
import { useForm } from 'react-hook-form';
import useUserStore from './store';
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

const AdminLogin = () => {
  const schema = yup.object({
    username:
    yup.string('Introduce nombre de usuario valido')
      .required('Introduce nombre de usuario valido')
      .min(3, 'El nombre de usuario no puede tener menos de 3 caracteres')
      .max(25, 'El nombre de usuario no puede tener más que 25 caracteres')
      .matches(
        /^(?=.*[a-zA-Z])[a-zA-Z0-9_-]+$/,
        'El nombre de usuario debe contener al menos una letra y solo puede incluir letras, números, _ y -'
      ),
    password:
    yup.string('Introduce contraseña valida')
      .required('Introduce contraseña valida')
      .min(8, 'Una contraseña tiene que tener un minimo de 8 caracteres')
      .max(35, 'Una contraseña no puede tener que tener más que 35 caracteres')
      .matches(
        /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,}$/,
        'La contraseña debe contener al menos una letra, un número y un carácter especial')
  });
  const form = useForm({
    resolver: yupResolver(schema),
    defaultValues: {
      username: '',
      password: ''
    }
  });
  const { login, loading } = useUserStore();
  const navigate = useNavigate();
  const [showPassword, setShowPassword] = useState(false);
  const onSubmit = async (data) => {
    await login(data);
    navigate('/auth/admin/personalizar');
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
                <Label htmlFor='username'>
                Usuario
                </Label>
                <Input
                  id='username'
                  name='username'
                  type='text'
                  placeholder='Escribe tu nombre de usuario'
                  {...form.register('username', { required: true })}
                />
                {form.formState.errors && <p className="text-red-500 text-sm">{form?.formState?.errors?.username?.message}</p>}
              </div>
              <div className='mt-4 flex flex-col gap-3 relative'>
                <Label htmlFor='password'>Contraseña</Label>
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
                  id='password'
                  name='password'
                  type={showPassword ? 'text' : 'password'}
                  placeholder='Escribe tu contraseña'
                  {...form.register('password', { required: true })}
                />
                {form.formState.errors && <p className="text-red-500 text-sm">{form?.formState?.errors?.password?.message}</p>}
              </div>
            </div>

            <div>
              <Button
                type='submit'
                disabled={loading}
                variant='default'
                className='w-full mt-4 py-6'
              >
                {loading ? 'Cargando...' : 'Continuar'}
              </Button>
            </div>
          </form>
        </Form>
      </div>
    </div>
  );
};

export default AdminLogin;
