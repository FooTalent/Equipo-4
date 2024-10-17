import { SlArrowLeft } from 'react-icons/sl';
import { useNavigate } from 'react-router-dom';
function Header() {
  const navigate = useNavigate();
  return (
    <div id='mentoringRequest-header'>
      <div
        id='mentoringRequest-header-container'
        className='flex flex-col w-[100%] h-full gap-2'
      >
        <div id='mentoringRequest-header-button' className='flex w-[100%]'>
          <button
            onClick={() => navigate('/admin/dashboard')}
            className='flex justify-start text-black'
            color='white'
            size='large'
          >
            <SlArrowLeft />
          </button>
        </div>
        <div id='mentoringRequest-header-title'>
          <h2 className='text-2xl'>Solicitud de Mentorias</h2>
        </div>
        <div id='mentoringRequest-header-divider'>
          <p className='font-bold'>
            Estas son las familias que esperan por recibir mentorías:
          </p>
        </div>
      </div>
    </div>
  );
}

export default Header;
