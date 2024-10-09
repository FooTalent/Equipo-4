import { useState } from 'react';
import { useForm } from 'react-hook-form';
import { useNavigate } from 'react-router-dom';
import { Link } from 'react-router-dom';
import { MdArrowBackIosNew } from 'react-icons/md';
import { Label } from '@/components/ui/label';
import { Input } from '@/components/ui/input';
import { Button } from '@/components/ui/button';
import { Checkbox } from '@/components/ui/checkbox';
import { Form } from '@/components/ui';
import * as yup from 'yup';
import { yupResolver } from '@hookform/resolvers/yup';
import { IoIosEyeOff, IoIosEye } from 'react-icons/io';

const PersonalizeCredentialsFamily= () => {
  const [showPassword, setShowPassword] = useState(false);
  const [showConfirmPassword, setShowConfirmPassword] = useState(false);
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
        'La contraseña debe contener al menos una letra, un número y un carácter especial'),
    confirmPassword: yup
      .string('Introduce tu contraseña de nuevo')
      .required('Tienes que introducir tu contraseña de nuevo')
      .oneOf([yup.ref('password')], 'La contraseña y la confirmación deben ser las mismas'),
    terms: yup.bool().oneOf([true], 'Debes aceptar los términos y condiciones'),
    contract: yup.bool().oneOf([true], 'Debes aceptar el contrato de confidencialidad')
  });
  const form = useForm({
    resolver: yupResolver(schema),
    defaultValues: {
      username: '',
      password: '',
      confirmPassword: '',
      terms: false,
      contract: false,
    }
  });
  const navigate = useNavigate();
  const handleTermsChange = () => {
    const currentValue = form.getValues('terms');
    form.setValue('terms', !currentValue, { shouldValidate: true });
  };

  const handleContractChange = () => {
    const currentValue = form.getValues('contract');
    form.setValue('contract', !currentValue, { shouldValidate: true });
  };
  const onSubmit = async (data) => {
    console.log(data);
    navigate('/dashboard');
  };

  return (
      <div className="flex flex-col items-center justify-center min-h-screen p-4 bg-custom">
        <Link className='absolute z-30 top-8 left-4' to={'/auth/admin/ingresar'}>
          <MdArrowBackIosNew />
        </Link>
        <div className="max-w-xl w-full h-auto space-y-8 bg-white md:h-3/4 md:shadow-lg  md:mx-auto md:w-full md:p-16 md:pb-28 md:pt-28 md:rounded-xl">
          <div>
            <h2 className="mt-2 text-center mb-16 text-3xl text-gray-900">
              Ahora, personaliza tus credenciales
            </h2>
          </div>
          <Form {...form}>
            <form className="mt-8 space-y-6" onSubmit={form.handleSubmit(onSubmit)}>
              <div className="rounded-md -space-y-px flex flex-col gap-4">

                <div className='flex flex-col gap-4 relative'>
                  <Label htmlFor="password">Nueva contraseña</Label>
                  <Input
                      id="password"
                      name="password"
                      type={showPassword ? 'text' : 'password'}
                      placeholder="Escribe tu nueva contraseña"
                      {...form.register('password')}
                  />
                  <button
                      type="button"
                      onClick={() => setShowPassword(!showPassword)}
                      className="absolute right-2 top-[42px]"
                  >
                    {showPassword ? (
                        <IoIosEyeOff className="text-gray-400" />
                    ) : (
                        <IoIosEye className="text-gray-400" />
                    )}
                  </button>
                  {form.formState.errors.password && (
                      <p className="text-red-500 text-sm">{form.formState.errors.password.message}</p>
                  )}
                </div>
                <div className='flex flex-col gap-4 relative'>
                  <Label htmlFor="confirmPassword" className="mt-4"  >Repetir contraseña</Label>
                  <Input
                      id="confirmPassword"
                      name="confirmPassword"
                      type={showConfirmPassword ? 'text' : 'password'}
                      placeholder="Repite tu nueva contraseña"
                      {...form.register('confirmPassword')}
                  />
                  <button
                      type="button"
                      onClick={() => setShowConfirmPassword(!showConfirmPassword)}
                      className="absolute right-2 top-[58px]"
                  >
                    {showConfirmPassword ? (
                        <IoIosEyeOff className="text-gray-400" />
                    ) : (
                        <IoIosEye className="text-gray-400" />
                    )}
                  </button>
                  {form.formState.errors.confirmPassword && (
                      <p className="text-red-500 text-sm">{form.formState.errors.confirmPassword.message}</p>
                  )}
                </div>
              </div>
              <div className='grid gap-2'>
                <div className="items-top mt-8 flex space-x-2">
                  <Checkbox id="terms" {...form.register('terms')} onClick={handleTermsChange} />
                  <div className='grid gap-1.5 leading-none'>
                    <label
                        htmlFor='terms'
                        className='text-sm font-medium leading-none peer-disabled:cursor-not-allowed peer-disabled:opacity-70'
                    >
                      Acepto <Link to={'/auth/familia/terminos'} className='underline text-[#00c14d]'>términos y condiciones</Link>
                    </label>
                  </div>
                </div>
                <div className="items-top mt-4 flex space-x-2">
                  <Checkbox id="contract" {...form.register('contract')} onClick={handleContractChange} />
                  <div className="grid gap-1.5 leading-none">
                    <label
                        htmlFor="contract"
                        className="text-sm font-medium leading-none peer-disabled:cursor-not-allowed peer-disabled:opacity-70"
                    >
                      Leí y acepto el <Link to={'/auth/familia/contrato-confidencialidad'} className='underline text-[#00c14d]'>contrato de confidencialidad</Link>
                    </label>
                  </div>
                </div>
                {form.formState.errors.terms && (
                    <p className="text-red-500 text-sm">{form.formState.errors.terms.message}</p>
                )}
                {form.formState.errors.contract && (
                    <p className="text-red-500 text-sm">{form.formState.errors.contract.message}</p>
                )}
              </div>
              <div>
                <Button
                    type="submit"
                    variant="default"
                    className="w-full mt-4 py-6 bg-button hover:bg-button-foreground"
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
