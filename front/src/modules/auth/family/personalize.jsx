import { useState, useEffect } from 'react';
import { useForm } from 'react-hook-form';
import { useNavigate, Link } from 'react-router-dom';
import { MdArrowBackIosNew } from 'react-icons/md';
import { Label } from '@/components/ui/label';
import { Input } from '@/components/ui/input';
import { Button } from '@/components/ui/button';
import { Checkbox } from '@/components/ui/checkbox';
import { Form } from '@/components/ui';
import * as yup from 'yup';
import { yupResolver } from '@hookform/resolvers/yup';
import { IoIosEyeOff, IoIosEye } from 'react-icons/io';
import { useMutation } from '@tanstack/react-query';
import { toast } from 'react-toastify';
import useAuthStore from '@/store/user.js';
import { personalizeFamilyApi } from '@/modules/auth/family/api/familyAuthApi.js';

const PersonalizeCredentialsFamily = () => {
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
  const setFirstLogin = useAuthStore((state) => state.setFirstLogin);
  const navigate = useNavigate();
  const [showPassword, setShowPassword] = useState(false);
  const [showConfirmPassword, setShowConfirmPassword] = useState(false);
  useEffect(() => {
    if (user) {
      if (user.tipoUsuario === 'FAMILIA') {
        if (user.primerIngreso === 'false') {
          navigate('/familia/dashboard');
        }
      } else {
        navigate('/');
      }
    }
    if (!user) navigate('/auth');
  }, [user, navigate]);

  const mutation = useMutation({
    mutationFn: personalizeFamilyApi,
    onSuccess: (data) => {
      if (data === 'Contraseña actualizada exitosamente.') {
        setFirstLogin('false');
        toast.success(data);
        navigate('/familia/dashboard');
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

  const handleTermsChange = () => {
    const currentValue = form.getValues('terms');
    form.setValue('terms', !currentValue, { shouldValidate: true });
  };

  const handleContractChange = () => {
    const currentValue = form.getValues('contract');
    form.setValue('contract', !currentValue, { shouldValidate: true });
  };

  return (
    <div className='relative md:bg-gray-300 py-8 h-screen grid md:flex md:flex-col md:gap-12 items-center px-4'>
      <Link className='block md:hidden absolute z-30 top-8 left-4' to={'/auth/ingresar'}><MdArrowBackIosNew /></Link>
      <Link to={'/auth'} className='hidden md:block top-4 left-4 w-full'>
        <img src='/common/logo-phrase.svg' alt='family one' className=''/>
      </Link>
      <div className='max-w-md w-full space-y-8 bg-white md:h-3/4 md:shadow-lg  md:mx-auto md:w-full md:p-5 md:rounded-xl'>
        <div className='flex flex-col gap-4'>
          <h2 className='mt-6 text-3xl text-gray-900'>
              Ahora, personaliza tus credenciales
          </h2>
        </div>
        <Form {...form}>
          <form className='mt-2 space-y-4' onSubmit={form.handleSubmit(onSubmit)}>
            <div className='rounded-md -space-y-px flex flex-col gap-2'>
              <div className='flex flex-col gap-2 relative'>
                <Label htmlFor='contrasenaHash'>Nueva contraseña</Label>
                <Input
                  id='contrasenaHash'
                  name='contrasenaHash'
                  type={showPassword ? 'text' : 'password'}
                  placeholder='Escribe tu nueva contraseña'
                  {...form.register('contrasenaHash')}
                />
                <button
                  type='button'
                  onClick={() => setShowPassword(!showPassword)}
                  className='absolute right-2 top-[42px]'
                >
                  {showPassword ? (
                    <IoIosEyeOff className='text-gray-400' />
                  ) : (
                    <IoIosEye className='text-gray-400' />
                  )}
                </button>
                {form.formState.errors.contrasenaHash && (
                  <p className='text-red-500 text-sm'>{form.formState.errors.contrasenaHash.message}</p>
                )}
              </div>
              <div className='flex flex-col gap-2 relative'>
                <Label htmlFor='confirmPassword' className='mt-4'>Repetir contraseña</Label>
                <Input
                  id='repiteContrasena'
                  name='repiteContrasena'
                  type={showConfirmPassword ? 'text': 'password'}
                  placeholder='Repite tu nueva contraseña'
                  {...form.register('repiteContrasena', { required: true })}
                />
                <button
                  type='button'
                  onClick={() => setShowConfirmPassword(!showConfirmPassword)}
                  className='absolute right-2 top-[58px]'
                >
                  {showConfirmPassword ? (
                    <IoIosEyeOff className='text-gray-400' />
                  ) : (
                    <IoIosEye className='text-gray-400' />
                  )}
                </button>
                {form.formState.errors && <p className='text-red-500 text-sm'>{form?.formState?.errors?.repiteContrasena?.message}</p>}
              </div>
            </div>
            <div className='grid gap-2'>
              <div className='items-top mt-2 flex space-x-2'>
                <Checkbox id='terms' {...form.register('terms')} onClick={handleTermsChange} />
                <div className='grid gap-1.5 leading-none'>
                  <label
                    htmlFor='terms'
                    className='text-sm font-medium leading-none peer-disabled:cursor-not-allowed peer-disabled:opacity-70'
                  >
                      Acepto <Link to={'/auth/familia/terminos'} className='underline text-[#00c14d]'>términos y condiciones</Link>
                  </label>
                </div>
              </div>
              <div className='items-top mt-4 flex space-x-2'>
                <Checkbox id='contract' {...form.register('contract')} onClick={handleContractChange} />
                <div className='grid gap-1.5 leading-none'>
                  <label
                    htmlFor='contract'
                    className='text-sm font-medium leading-none peer-disabled:cursor-not-allowed peer-disabled:opacity-70'
                  >
                      Leí y acepto el <Link to={'/auth/familia/contrato-confidencialidad'} className='underline text-[#00c14d]'>contrato de confidencialidad</Link>
                  </label>
                </div>
              </div>
              {form.formState.errors.terms && (
                <p className='text-red-500 text-sm'>{form.formState.errors.terms.message}</p>
              )}
              {form.formState.errors.contract && (
                <p className='text-red-500 text-sm'>{form.formState.errors.contract.message}</p>
              )}
            </div>
            <div>
              <Button
                type='submit'
                variant='default'
                className='w-full mt-4 py-6 bg-orange-400  hover:border-orange-500 hover:border-2 hover:bg-white text-black hover:text-black'
              >
                  Continuar
              </Button>
            </div>
          </form>
        </Form>
      </div>
    </div>
  );
};

export default PersonalizeCredentialsFamily;