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
          <img src='/common/delete.svg' alt='borar' className='absolute top-2 right-2' />
          <img src='/common/edit-input-field.svg' alt='editar' className='absolute top-[9.5px] right-10' />
        </div>

      </div>
    </>
  );
}