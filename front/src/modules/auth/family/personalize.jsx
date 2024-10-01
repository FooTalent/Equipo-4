import { useForm } from 'react-hook-form';
import { useNavigate } from 'react-router-dom';
import { Link } from 'react-router-dom';
import { MdArrowBackIosNew } from 'react-icons/md';
import { Label } from '@/components/ui/label';
import { Input } from '@/components/ui/input';
import { Button } from '@/components/ui/button';
import { Checkbox } from '@/components/ui/checkbox';

const PersonalizeCredentialsFamily= () => {
  const { register, handleSubmit } = useForm();
  const navigate = useNavigate();

  const onSubmit = async (data) => {
    console.log(data);
    navigate('/dashboard');
  };

  return (
    <div className="flex flex-col items-center justify-center min-h-screen p-4">
      <Link className='absolute z-30 top-8 left-4' to={'/auth/admin/ingresar'}>
        <MdArrowBackIosNew />
      </Link>
      <div className="max-w-md w-full space-y-8">
        <div>
          <h2 className="mt-6 text-center text-3xl text-gray-900">
            Ahora, personaliza tus credenciales
          </h2>
        </div>
        <form className="mt-8 space-y-6" onSubmit={handleSubmit(onSubmit)}>
          <div className="rounded-md shadow-sm -space-y-px flex flex-col gap-4">
            <div className='flex flex-col gap-2'>
              <Label htmlFor="username">Usuario</Label>
              <Input
                id="username"
                name="username"
                type="text"
                placeholder="Escribe tu nombre de usuario"
                {...register('username', { required: true })}
              />
            </div>
            <div className='flex flex-col gap-2'>
              <Label htmlFor="newPassword">Nueva contraseña</Label>
              <Input
                id="newPassword"
                name="newPassword"
                type="password"
                placeholder="Escribe tu nueva contraseña"
                {...register('newPassword', { required: true })}
              />
            </div>
            <div className='flex flex-col gap-2'>
              <Label htmlFor="confirmPassword">Repite contraseña</Label>
              <Input
                id="confirmPassword"
                name="confirmPassword"
                type="password"
                placeholder="Repite tu nueva contraseña"
                {...register('confirmPassword', { required: true })}
              />
            </div>
          </div>

          {/* {error && <p className="text-red-500 text-sm">{error}</p>} */}

          <div className='grid gap-2 '>
            <div className="items-top flex space-x-2">
              <Checkbox id="terms1" />
              <div className="grid gap-1.5 leading-none">
                <label
                  htmlFor="terms1"
                  className="text-sm font-medium leading-none peer-disabled:cursor-not-allowed peer-disabled:opacity-70"
                >
                Acepto <Link to={'/auth/terminos'} className='underline'>términos y condiciones</Link>
                </label>
              </div>
            </div>
            <div className="items-top flex space-x-2">
              <Checkbox id="terms2" />
              <div className="grid gap-1.5 leading-none">
                <label
                  htmlFor="terms1"
                  className="text-sm font-medium leading-none peer-disabled:cursor-not-allowed peer-disabled:opacity-70"
                >
                Leí y acepto el <Link to={'/auth/contrato-confidencialidad'} className='underline'>contrato de confidencialidad</Link>
                </label>
              </div>
            </div>
          </div>
          <div>
            <Button
              type="submit"
              variant="default"
              className="w-full mt-4 py-6"
            >
              {'Continuar'}
            </Button>
          </div>
        </form>
      </div >
    </div >
  );
};

export default PersonalizeCredentialsFamily;
