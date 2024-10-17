import { useEffect, useState } from 'react';
import comunas from '../../../../public/common/data/territoriochile.json';
import { useForm, Controller } from 'react-hook-form';
import { Button, Input } from '@/components/ui';
import useAuthStore from '@/store/user';
import { createFamily } from './api/createFamily';
import Navbar from '@/components/shared/navbar';
import Footer from '@/components/shared/footer';

export default function HomeFamilies() {
  const user = useAuthStore((state) => state.user);
  const { control, register, handleSubmit, setValue } = useForm();
  const [twoMembers, setTwoMembers] = useState(null);
  const [userData, setUserData] = useState(null);

  const onSubmit = (data) => {
    const mappedData = {
      ...data,
      usuario: userData,
      fechaNacimientoFaUno: data.fechaNacimientoFaUno
        ? new Date(data.fechaNacimientoFaUno).toISOString()
        : null,
      fechaNacimientoFaDos: data.fechaNacimientoFaDos
        ? new Date(data.fechaNacimientoFaDos).toISOString()
        : null,
      ingresoFa: data.ingresoFa ? new Date(data.ingresoFa).toISOString() : null,
      ingresoAfac: data.ingresoAfac
        ? new Date(data.ingresoAfac).toISOString()
        : null,
      fechaUltimoContacto: data.fechaUltimoContacto
        ? new Date(data.fechaUltimoContacto).toISOString()
        : null,
    };
    createFamily(mappedData);
  };

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setValue(name, value);
  };

  useEffect(() => {
    if (user) {
      setUserData(user.id);
    }
  // eslint-disable-next-line react-hooks/exhaustive-deps
  }, []);

  return (
    <main>
      <Navbar />
      <div
        id='home-families-container'
        className='w-[100%] bg-grayDefault'
      >
        <div
          id='home-families'
          className='flex items-center justify-center h-full'
        >
          <div
            id='home-families-content'
            className='pt-[25px] pr-[20px] pb-[25px] pl-[20px] w-[95%] flex justify-center'
          >
            <div
              id='home-families-form'
              className='bg-white rounded-[12px] pt-[20px] pr-[20px] pb-[25px] pl-[20px] w-[668px]'
            >
              <section
                id='home-families-form-title'
                className='flex-col w-full'
              >
                <h1 className='font-[400] text-2xl'>Bienvenidos</h1>
              </section>
              <form
                id='home-families-form'
                className='flex flex-col w-full gap-10'
                onSubmit={handleSubmit(onSubmit)}
              >
                <section className='flex flex-col gap-5'>
                  <div>
                    <h2 className='font-[500] text-1xl'>
                      Datos personales del representante de familia
                    </h2>
                  </div>
                  <div className='w-full'>
                    <label className='font-[500] text-1xl'>
                      Cantidad de miembros representantes
                    </label>
                    <select
                      className='w-full'
                      value={twoMembers ? '2' : '1'}
                      onChange={(e) => setTwoMembers(e.target.value === '2')}
                    >
                      <option value='1'>1</option>
                      <option value='2'>2</option>
                    </select>
                  </div>
                  <Input
                    name='nombreFaUno'
                    label='nombreFaUno'
                    placeholder='Nombre y Apellido Representante'
                    type='text'
                    onChange={handleInputChange}
                    {...register('nombreFaUno', {
                      required: true,
                      maxLength: 255,
                    })}
                  />
                  <Input
                    label='rutFaUno'
                    placeholder='RUT Representante'
                    type='text'
                    onChange={handleInputChange}
                    {...register('rutFaUno', {
                      required: true,
                      maxLength: 12,
                    })}
                  />
                  <div>
                    <label className='font-[500] text-1xl'>
                      Fecha de Nacimiento Familiar
                    </label>
                    <Input
                      label='fechaNacimientoFaUno'
                      placeholder='Fecha de Nacimiento'
                      type='date'
                      onChange={handleInputChange}
                      {...register('fechaNacimientoFaUno')}
                    />
                  </div>
                  <select
                    className='flex w-full h-10 px-3 py-2 text-sm border rounded-md border-input bg-background ring-offset-background file:border-0 focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2 disabled:cursor-not-allowed disabled:opacity-50'
                    {...register('estadoCivil')}
                  >
                    <option>Estado Civil</option>
                    {[
                      'Soltero/a',
                      'Casado/a',
                      'Divorciado/a',
                      'Viudo/a',
                      'En pareja',
                      'Separado/a',
                    ].map((estado, index) => (
                      <option key={index} value={estado}>
                        {estado}
                      </option>
                    ))}
                  </select>
                  <Input
                    label='telefono'
                    placeholder='Teléfono'
                    type='text'
                    onChange={handleInputChange}
                    {...register('telefono')}
                  />
                  <Input
                    label='email'
                    placeholder='Email'
                    type='text'
                    onChange={handleInputChange}
                    {...register('email')}
                  />
                  <Input
                    label='pais'
                    placeholder='Pais'
                    type='text'
                    onChange={handleInputChange}
                    {...register('pais')}
                  />
                  <Input
                    label='region'
                    placeholder='Ciudad'
                    type='text'
                    onChange={handleInputChange}
                    {...register('region')}
                  />
                  <select
                    className='flex w-full h-10 px-3 py-2 text-sm border rounded-md border-input bg-background ring-offset-background file:border-0 focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2 disabled:cursor-not-allowed disabled:opacity-50'
                    onChange={handleInputChange}
                    {...register('comuna')}
                  >
                    <option className='disabled' disabled>
                      Comuna / Región
                    </option>
                    {comunas.map((comuna, index) => (
                      <option key={index} value={comuna.nombre}>
                        {comuna.nombre}
                      </option>
                    ))}
                  </select>
                  <Input
                    label='direccion'
                    placeholder='Dirección'
                    type='text'
                    onChange={handleInputChange}
                    {...register('direccion')}
                  />
                </section>
                {/*Miembro dos*/}
                {twoMembers && (
                  <section className='flex flex-col gap-5'>
                    <h2 className='font-[500] text-1xl'>
                      Segundo Representante
                    </h2>
                    <Input
                      label='nombreFaUno'
                      placeholder='Nombre y Apellido Representante'
                      type='text'
                      onChange={handleInputChange}
                      {...register('nombreFaDos', {
                        required: true,
                        maxLength: 255,
                      })}
                    />
                    <Input
                      label='rutFaDos'
                      placeholder='RUT Representante'
                      type='text'
                      onChange={handleInputChange}
                      {...register('rutFaDos', {
                        required: true,
                        maxLength: 12,
                      })}
                    />
                    <div>
                      <label className='font-[500] text-1xl'>
                        Fecha de Nacimiento Familiar
                      </label>
                      <Input
                        label='fechaNacimientoFaDos'
                        placeholder='Fecha de Nacimiento'
                        type='date'
                        onChange={handleInputChange}
                        {...register('fechaNacimientoFaDos')}
                      />
                    </div>
                  </section>
                )}
                {/*Miembro dos*/}
                <div className='flex flex-col gap-5'>
                  <section>
                    <div>
                      <h2 className='font-[500] text-1xl'>
                        Estado acogimiento
                      </h2>
                    </div>
                    <Controller
                      name='estadoAcogimiento'
                      control={control}
                      render={({ field }) => (
                        <div>
                          <div className='flex items-center gap-2'>
                            <input
                              type='radio'
                              value='A'
                              {...field}
                              checked={field.value === 'A'}
                              onChange={() => field.onChange('A')}
                            />
                            <label className='text-sm'>Acogiendo</label>
                          </div>
                          <div className='flex items-center gap-2'>
                            <input
                              type='radio'
                              value='SA'
                              {...field}
                              checked={field.value === 'SA'}
                              onChange={() => field.onChange('SA')}
                            />
                            <label className='text-sm'>Sin acogimiento</label>
                          </div>
                          <div className='flex items-center gap-2'>
                            <input
                              type='radio'
                              value='AP'
                              {...field}
                              checked={field.value === 'AP'}
                              onChange={() => field.onChange('AP')}
                            />
                            <label className='text-sm'>
                              Acogida Permanente
                            </label>
                          </div>
                        </div>
                      )}
                    />
                  </section>
                  <section>
                    <div>
                      <h2 className='font-[500] text-1xl'>
                        ¿Ya tienes asignado algún rol como familia voluntaria en
                        AFAC? Si es así, ¿nos podrías indicar cuál es?
                      </h2>
                    </div>
                    <Input
                      label='RolAfac'
                      type='text'
                      placeholder='Rol como voluntario en AFAC'
                      onChange={handleInputChange}
                      {...register('RolAfac')}
                    />
                  </section>
                  <section>
                    <div>
                      <h2 className='font-[500] text-1xl'>
                        Según la experiencia como familia de acogimiento,
                        considerarías:
                      </h2>
                    </div>
                    <Controller
                      name='experenciaAcogimiento'
                      control={control}
                      render={({ field }) => (
                        <div>
                          <div className='flex items-center gap-2'>
                            <input
                              type='radio'
                              value='solicitarMentoria'
                              {...field}
                              checked={field.value === 'solicitarMentoria'}
                              onChange={() =>
                                field.onChange('solicitarMentoria')
                              }
                            />
                            <label className='text-sm'>
                              Solicitar mentoría
                            </label>
                          </div>
                          <div className='flex items-center gap-2'>
                            <input
                              type='radio'
                              value='postularFamiliaVoluntaria'
                              {...field}
                              checked={
                                field.value === 'postularFamiliaVoluntaria'
                              }
                              onChange={() =>
                                field.onChange('postularFamiliaVoluntaria')
                              }
                            />
                            <label className='text-sm'>
                              Postular como familia voluntaria
                            </label>
                          </div>
                          <div className='flex items-center gap-2'>
                            <input
                              type='radio'
                              value='ninguna'
                              {...field}
                              checked={field.value === 'ninguna'}
                              onChange={() => field.onChange('ninguna')}
                            />
                            <label className='text-sm'>
                              Por el momento ninguna de las anteriores
                            </label>
                          </div>
                        </div>
                      )}
                    />
                  </section>
                </div>
                <div className='flex justify-center'>
                  <Button
                    type='submit'
                    className='w-full py-3 text-base font-bold text-center text-black bg-orange-400 rounded-md md:w-3/4 hover:bg-orange-500 hover:opacity-80'
                  >
                    Guardar Cambios
                  </Button>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
      <Footer />
    </main>
  );
}
