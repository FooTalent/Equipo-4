import { Link } from 'react-router-dom';

export default function Auth() {
  return (
    <main className='py-8 h-screen grid items-center px-4 text-center max-w-4xl mx-auto'>
      <div className='flex flex-col gap-6 self-end text-left md:items-center md:text-center'>
        <div className='grid w-full md:justify-center md:items-center'>
          <img src='/common/logo.svg' className='w-44 md:ml-[45%] md:w-52'/>
        </div>
        <h1 className='text-4xl md:text-5xl font-extralight'>
        Bienvenido al <br /> Sistema de Gestión <br /> de Datos de <span className='font-bold'>AFAC</span>
        </h1>
      </div>
      <Link to={'/auth/tipo-usuario'} className="self-end bg-black text-base hover:opacity-80 py-3 text-white rounded-md">Continuar</Link>
    </main>
  );
}