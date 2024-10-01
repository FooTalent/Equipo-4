import React from 'react';
import { useForm } from 'react-hook-form';
import useUserStore from './store';
import { useNavigate } from 'react-router-dom';
import { Link } from 'react-router-dom';
import { MdArrowBackIosNew } from 'react-icons/md';
import { Input } from '/src/components/ui/input';
import { Label } from '/src/components/ui/label';
import { Button } from '/src/components/ui/button';

const Admin = () => {
  const { register, handleSubmit } = useForm();
  const { login, loading, error } = useUserStore();
  const navigate = useNavigate();

  const onSubmit = async (data) => {
    await login(data);
    navigate('/personalize'); // Redirigir a la siguiente vista
  };

  return (
    <div className="flex flex-col items-center justify-center min-h-screen p-4">
      <Link className='absolute z-30 top-8 left-4' to={'/auth'}>
        <MdArrowBackIosNew />
      </Link>
      <div className="max-w-md w-full space-y-8">
        <div>
          <h2 className="mt-6 text-3xl text-gray-900">
            Ingresa las credenciales suministradas
          </h2>
        </div>
        <form className="mt-8 space-y-6" onSubmit={handleSubmit(onSubmit)}>
          <div className="rounded-md shadow-sm -space-y-px">
            <div className="mb-4">
              <Label htmlFor="username">
                Usuario
              </Label>
              <Input
            id="username"
            name="username"
            type="text"
            placeholder="Escribe tu nombre de usuario"
            {...register('username', { required: true })}
          />
            </div>
            <div className="mt-4">
              <Label htmlFor="password">Contraseña</Label>
              <Input
                id="password"
                name="password"
                type="password"
                placeholder="Escribe tu contraseña"
                {...register('password', { required: true })}
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
              {loading ? 'Cargando...' : 'Continuar'}
            </Button>
          </div>
        </form>
      </div>
    </div>
  );
};

export default Admin;
