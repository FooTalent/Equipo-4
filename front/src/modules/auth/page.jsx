import { Link } from 'react-router-dom';

export default function Auth() {
  return (
    <main className='py-8 h-screen grid items-center px-4 text-center'>
      <h1 className='self-end md:text-2xl lg:text-4xl'>
        Bienvenido al Sistema de Gestión de Datos de <span className='font-bold'>AFAC</span>
      </h1>
      <Link to={'/auth/usuario'} className="self-end bg-black text-base hover:opacity-80 py-3 text-white rounded-md">Continuar</Link>
    </main>
  );
}