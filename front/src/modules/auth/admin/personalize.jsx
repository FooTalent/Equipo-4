import React from 'react';
import { useForm } from 'react-hook-form';
import useUserStore from './store';
import { useNavigate } from 'react-router-dom';
import { Link } from 'react-router-dom';
import { MdArrowBackIosNew } from 'react-icons/md';
import { Label } from '@/components/ui/label';
import { Input } from '@/components/ui/input';
import { Button } from '@/components/ui/button';

const PersonalizeCredentials = () => {
  const { register, handleSubmit } = useForm();
  const { register: registerUser, loading, error } = useUserStore();
  const navigate = useNavigate();

  const onSubmit = async (data) => {
    await registerUser(data);
    navigate('/dashboard');
  };

  return (
    <div className="flex flex-col items-center justify-center min-h-screen p-4">
      <Link className='absolute z-30 top-8 left-4' to={'/auth/administrador'}>
        <MdArrowBackIosNew />
      </Link>
      <div className="max-w-md w-full space-y-8">
        <div>
          <h2 className="mt-6 text-center text-3xl text-gray-900">
            Ahora, personaliza tus credenciales
          </h2>
        </div>
        <form className="mt-8 space-y-6" onSubmit={handleSubmit(onSubmit)}>
          <div className="rounded-md shadow-sm -space-y-px">
            <div>
              <Label htmlFor="username">Usuario</Label>
              <Input
                id="username"
                name="username"
                type="text"
                placeholder="Escribe tu nombre de usuario"
                {...register('username', { required: true })}
                className="appearance-none rounded-none relative block w-full px-3 py-2 border border-gray-300 placeholder-gray-500 text-gray-900 rounded-t-md focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 focus:z-10 sm:text-sm"
              />
            </div>
            <div className="mt-4">
              <Label htmlFor="newPassword">Nueva contraseña</Label>
              <Input
                id="newPassword"
                name="newPassword"
                type="password"
                placeholder="Escribe tu nueva contraseña"
                {...register('newPassword', { required: true })}
                className="appearance-none rounded-none relative block w-full px-3 py-2 border border-gray-300 placeholder-gray-500 text-gray-900 rounded-t-md focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 focus:z-10 sm:text-sm"
              />
            </div>
            <div className="mt-4">
              <Label htmlFor="confirmPassword">Repite contraseña</Label>
              <Input
                id="confirmPassword"
                name="confirmPassword"
                type="password"
                placeholder="Repite tu nueva contraseña"
                {...register('confirmPassword', { required: true })}
                className="appearance-none rounded-none relative block w-full px-3 py-2 border border-gray-300 placeholder-gray-500 text-gray-900 rounded-b-md focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 focus:z-10 sm:text-sm"
              />
            </div>
          </div>

          {error && <p className="text-red-500 text-sm">{error}</p>}

          <div>
            <Button
              type="submit"
              disabled={loading}
              variant="default"
              className="w-full"
            >
              {loading ? 'Cargando...' : 'Iniciar Sesión'}
            </Button>
          </div>
        </form>
      </div >
    </div >
  );
};

export default PersonalizeCredentials;
