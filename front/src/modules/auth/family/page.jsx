import {useEffect, useState} from 'react';
import { useForm } from 'react-hook-form';
import { useNavigate, Link } from 'react-router-dom';
import { MdArrowBackIosNew } from 'react-icons/md';
import { Input } from '/src/components/ui/input';
import { Label } from '/src/components/ui/label';
import { Button } from '/src/components/ui/button';
import { Form } from '@/components/ui';
import * as yup from 'yup';
import { yupResolver } from '@hookform/resolvers/yup';
import { IoIosEyeOff, IoIosEye } from 'react-icons/io';
import {useMutation} from "@tanstack/react-query";
import {toast} from "react-toastify";
import useAuthStore from "@/store/user.js";
import {loginFamilyApi} from "@/modules/auth/family/api/familyAuthApi.js";

const FamilyLogin = () => {
  const user = useAuthStore((state) => state.user);
  const setUser = useAuthStore((state) => state.setUser);
  const schema = yup.object({
    correo:
        yup.string('Introduce un correo valido')
            .required('Introduce un correo valido')
            .email('Introduce un correo valido'),
    contrasenaHash:
        yup.string('Introduce contraseña valida')
            .required('El campo contraseña no puede estar vacio')
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
  const navigate = useNavigate();
  const [showPassword, setShowPassword] = useState(false);
  useEffect(() => {
    if (user) {
      if (user.tipoUsuario === 'FAMILIA') {
        if (user.primerIngreso === 'true') {
          navigate('/auth/familia/personalizar');
        } else {
          navigate('/familia/dashboard');
        }
      } else {
        navigate('/');
      }
    }
  }, [user, navigate]);

  const mutation = useMutation({
    mutationFn: loginFamilyApi,
    onSuccess: (data) => {
      if (data.correo) {
        setUser(data);
        toast.success('Inicio de sesión exitoso');
        if (data.tipoUsuario === 'FAMILIA') {
          if (data.primerIngreso === 'true') {
            navigate('/auth/familia/personalizar');
          } else {
            navigate('/familia/dashboard');
          }
        } else {
          navigate('/');
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
    <div className='flex flex-col items-center justify-center min-h-screen p-4 md:bg-green'>
      <Link className='absolute top-8 left-4 sm:top-8 sm:left-8 bg-white md:p-4 md:shadow-md md:rounded-xl left-8' to={'/auth/tipo-usuario'}>
        <MdArrowBackIosNew className="text-2xl" />
      </Link>
      <Link to={'/auth'} className='hidden md:block left-4 w-full'>
        <img src='/common/logo-phrase.svg' alt='family one' className='absolute top-30 sm:left-20 ml-20 mb-20'/>
      </Link>
      <div className='max-w-[450px] z-30 w-full h-auto space-y-8 md:bg-white md:h-3/4 md:shadow-lg  md:mx-auto md:w-full md:p-20 md:pb-20 md:pt-14 md:rounded-xl'>
        <div>
          <h2 className='mt-6 text-2xl sm:text-3xl font-bold text-center text-gray-900'>
            Ingresa tus credenciales
          </h2>
        </div>
        <Form {...form}>
          <form className='mt-8 space-y-6' onSubmit={form.handleSubmit(onSubmit)}>
            <div className='rounded-md space-y-4'>
              <div className='flex flex-col gap-2'>
                <Label htmlFor='username' className="text-sm font-medium text-gray-700">
                Correo
                </Label>
                <Input
                  id='correo'
                  name='correo'
                  type='text'
                  className='px-3 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500'
                  placeholder='Escribe tu correo electrónico'
                  {...form.register('correo', { required: true })}
                />
                {form.formState.errors && <p className="text-red-500 text-xs">{form?.formState?.errors?.correo?.message}</p>}
              </div>
              <div className='flex flex-col gap-2 relative'>
                <Label htmlFor='password' className="text-sm font-medium text-gray-700">Contraseña</Label>
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
                  {...form.register('contrasenaHash', { required: true })}
                />
                {form.formState.errors && <p className="text-red-500 text-sm">{form?.formState?.errors?.contrasenaHash?.message}</p>}
              </div>
                <div className="flex items-center justify-center">
                    <div className="text-sm">
                        <Link to="/auth/familia/olvidar-contrasena" className="font-medium text-gray-700 hover:text-orange-600 text-center justify-center">
                            ¿Olvidaste tu contraseña?
                        </Link>
                    </div>
                </div>
            </div>

            <div>
              <Button
                type='submit'
                variant='default'
                className='w-full mt-4 py-6 bg-orange-400  hover:border-orange-500 hover:border-2 hover:bg-white text-black hover:text-black'
              >
                {'Continuar'}
              </Button>
            </div>
          </form>
        </Form>
      </div>
    </div>
  );
};

export default FamilyLogin;
