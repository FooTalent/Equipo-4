/* eslint-disable no-unused-vars */
import { Input } from '@/components/ui';

export default function Familia({ id, usuario, nombreFaUno }) {
  return (
    <>
      <div className='flex flex-col gap-3'>
        <div className='relative'>
          <Input
            className='border-gray-400 focus-visible:ring-0 focus-visible:ring-offset-0 placeholder:text-gray-400'
            placeholder={`${nombreFaUno ? nombreFaUno : 'Nombre y Apellido'}`}
            disabled
          />
        </div>

      </div>
    </>
  );
}