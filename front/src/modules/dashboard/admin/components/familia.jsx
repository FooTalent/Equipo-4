/* eslint-disable no-unused-vars */
import { Input } from '@/components/ui';
import { Link } from 'react-router-dom';

export default function Familia({ id, usuario, nombreFaUno }) {
  return (
    <Link to={`/admin/familia/${id}`} className='hover:cursor-pointer'>
      <div className='flex flex-col gap-3'>
        <div className='relative'>
          <Input
            className='hover:cursor-pointer border-gray-400 focus-visible:ring-0 focus-visible:ring-offset-0 placeholder:text-gray-400'
            placeholder={`${nombreFaUno ? nombreFaUno : 'Nombre y Apellido'}`}
          />
        </div>

      </div>
    </Link>
  );
}