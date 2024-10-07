export default function Footer() {
  return (
    <footer className='bg-orangeLight flex justify-between items-center px-3 py-3'>
      <div className=' flex flex-col items-center'>
        <img src='/common/home.svg' alt='pagina principal' />
        <p>Inicio</p>
      </div>
      <div className=' flex flex-col items-center'>
        <img src='/common/email.svg' alt='correos' />
        <p>E-Mail</p>
      </div>
      <div className=' flex flex-col items-center'>
        <img src='/common/email.svg' alt='notificación' />
        <p>Notificación</p>
      </div>
      <div className=' flex flex-col items-center'>
        <img src='/common/perfil.svg' alt='perfil' />
        <p>Perfil</p>
      </div>
    </footer>
  );
}