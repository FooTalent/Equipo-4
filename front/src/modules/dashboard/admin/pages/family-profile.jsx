import { Button, Form, Input, RadioGroup, RadioGroupItem } from '@/components/ui';
import { AppLayout } from '@/layouts/app-layout';
import useAuthStore from '@/store/user';
import { Label } from '@radix-ui/react-label';
import { useEffect, useState } from 'react';
import { useForm } from 'react-hook-form';
import { useNavigate, useParams } from 'react-router-dom';
import { searchFamilyApi } from '../api';
import { toast } from 'react-toastify';
import { useQuery } from '@tanstack/react-query';

export default function FamilyProfile() {
  const { id } = useParams();
  const user = useAuthStore((state) => state.user);
  const navigate = useNavigate();
  const [currentForm, setCurrentForm] = useState(1);
  const handleNavigation = () => {
    if (currentForm === 1) navigate('/admin/listado-familias');
    if (currentForm === 2) setCurrentForm(1);
    if (currentForm === 3) setCurrentForm(2);
  };
  const form = useForm({
    defaultValues: {}
  });
  const { data: familia, isLoading } = useQuery({
    queryFn: () => searchFamilyApi(id),
    onError: () => {
      toast.error('Ha ocurrido un error');
    },
  });
  useEffect(() => {
    if (!user) navigate('/auth');
    if (user && user.tipoUsuario !== 'ADMIN') navigate('/familia');
  }, [user, navigate, id]);
  return (
    <AppLayout>
      <section className='h-full md:bg-grayDefault md:grid'>
        <div className='p-0 grid md:flex md:flex-col gap-6 max-w-6xl mx-auto px-2 md:px-4 md:py-4 md:mb-6 md:mt-[10vh] md:h-fit md:bg-white md:w-[650px] md:rounded-lg md:border-0 md:mx-auto'>
          <div className='flex flex-col gap-4'>
            {isLoading && (
              <div className='grid justify-center items-center mt-12'>
                <div className='animate-spin rounded-full h-12 w-12 border-b-2 border-gray-400'></div>
              </div>
            )}
            {!isLoading && familia && <>
              <div className='flex md:flex-col gap-2'>
                <img onClick={handleNavigation} src='/common/arrow-left.svg' alt='Regresar a la página principal' className='self-start pt-2 md:pt-0 hover:cursor-pointer' />
                <p className={`${currentForm === 1 ? 'block' : 'hidden'} self-center -mb-2 md:-mb-0 text-2xl md:w-full`}>Perfil familia {familia?.nombreFaUno}</p>
              </div>
            </>}
          </div>
          <div className='flex flex-col gap-3'>
            <>
              <Form {...form}>
                <form>
                  <div>
                    {!isLoading && familia && <>
                      <section className={`${currentForm === 1 ? 'flex' : 'hidden'} flex-col gap-3 pt-4 md:pt-0`}>
                        <p className='text-sm -mt-5 font-semibold'>Datos personales</p>
                        <div className='relative'>
                          <Input
                            className='border-gray-400 focus-visible:ring-0 focus-visible:ring-offset-0 placeholder:text-gray-400'
                            placeholder={`${familia?.nombreFaUno ? familia.nombreFaUno : 'Nombre y Apellido'}`}
                            disabled
                          />
                          <img src='/common/edit-2.svg' alt='borrar la familia' className='absolute top-2 right-2' />
                        </div>
                        <div className='relative'>
                          <Input
                            className='border-gray-400 focus-visible:ring-0 focus-visible:ring-offset-0 placeholder:text-gray-400'
                            placeholder={`${familia?.rutFaUno ? familia.rutFaUno : 'Rut'}`}
                            disabled
                          />
                          <img src='/common/edit-2.svg' alt='borrar la familia' className='absolute top-2 right-2' />
                        </div>
                        <div className='relative'>
                          <Input
                            className='border-gray-400 focus-visible:ring-0 focus-visible:ring-offset-0 placeholder:text-gray-400'
                            placeholder={`${familia?.fechaNacimientoFaUno ? `${familia?.fechaNacimientoFaUno[2]}/${familia?.fechaNacimientoFaUno[1]}/${familia?.fechaNacimientoFaUno[0]}` : 'Fecha Nacimiento'}`}
                            disabled
                          />
                          <img src='/common/edit-2.svg' alt='borrar la familia' className='absolute top-2 right-2' />
                        </div>
                        <div className='relative'>
                          <Input
                            className='border-gray-400 focus-visible:ring-0 focus-visible:ring-offset-0 placeholder:text-gray-400'
                            placeholder={`${familia?.estadoCivil ? familia?.estadoCivil : 'Estado Civil'}`}
                            disabled
                          />
                          <img src='/common/edit-2.svg' alt='borrar la familia' className='absolute top-2 right-2' />
                        </div>
                        <div className='relative'>
                          <Input
                            className='border-gray-400 focus-visible:ring-0 focus-visible:ring-offset-0 placeholder:text-gray-400'
                            placeholder={`${familia?.telefono ? familia?.telefono : 'Telefono'}`}
                            disabled
                          />
                          <img src='/common/edit-2.svg' alt='borrar la familia' className='absolute top-2 right-2' />
                        </div>
                        <div className='relative'>
                          <Input
                            className='border-gray-400 focus-visible:ring-0 focus-visible:ring-offset-0 placeholder:text-gray-400'
                            placeholder={`${familia?.email ? familia?.email : 'Email'}`}
                            disabled
                          />
                          <img src='/common/edit-2.svg' alt='borrar la familia' className='absolute top-2 right-2' />
                        </div>
                        <div className='relative'>
                          <Input
                            className='border-gray-400 focus-visible:ring-0 focus-visible:ring-offset-0 placeholder:text-gray-400'
                            placeholder={`${familia?.region ? familia?.region : 'Region'}`}
                            disabled
                          />
                          <img src='/common/edit-2.svg' alt='borrar la familia' className='absolute top-2 right-2' />
                        </div>
                        <div className='relative'>
                          <Input
                            className='border-gray-400 focus-visible:ring-0 focus-visible:ring-offset-0 placeholder:text-gray-400'
                            placeholder={`${familia?.comuna ? familia?.comuna : 'Cómuna'}`}
                            disabled
                          />
                          <img src='/common/edit-2.svg' alt='borrar la familia' className='absolute top-2 right-2' />
                        </div>
                        <div className='relative'>
                          <Input
                            className='border-gray-400 focus-visible:ring-0 focus-visible:ring-offset-0 placeholder:text-gray-400'
                            placeholder={`${familia?.direccion ? familia?.direccion : 'Dirección'}`}
                            disabled
                          />
                          <img src='/common/edit-2.svg' alt='borrar la familia' className='absolute top-2 right-2' />
                        </div>
                        <div className='pb-2'>
                          <Button onClick={() => setCurrentForm(2)} type='button' variant='green' className='w-full'>Continuar</Button>
                        </div>
                      </section>
                      <section className={`${currentForm === 2 ? 'flex' : 'hidden'} flex-col gap-3 pt-4 md:pt-0`}>
                        <p className='text -mt-3 font-semibold'>Datos de familia de Acogimiento</p>
                        <div className='flex flex-col gap-2'>
                          <Label className=''>Feche de ingreso a AFAC</Label>
                          <div className='relative '>
                            <Input
                              className='border-gray-400 focus-visible:ring-0 focus-visible:ring-offset-0 placeholder:text-gray-400'
                              placeholder={`${familia?.ingresoAfac ? `${familia?.ingresoAfac[2]}/${familia?.ingresoAfac[1]}/${familia?.ingresoAfac[0]}` : 'dd/mm/aaaa'}`}
                              disabled
                            />
                            <img src='/common/edit-2.svg' alt='borrar la familia' className='absolute top-2 right-2' />
                          </div>
                        </div>
                        <div className='relative flex flex-col gap-2'>
                          <Label className=''>Feche de ingreso como FA</Label>
                          <div className='relative'>
                            <Input
                              className='border-gray-400 focus-visible:ring-0 focus-visible:ring-offset-0 placeholder:text-gray-400'
                              placeholder={`${familia?.ingresoFa ? `${familia?.ingresoFa[2]}/${familia?.ingresoFa[1]}/${familia?.ingresoFa[0]}` : 'dd/mm/aaaa'}`}
                              disabled
                            />
                            <img src='/common/edit-2.svg' alt='borrar la familia' className='absolute top-2 right-2' />
                          </div>
                        </div>
                        <div className='relative flex flex-col gap-2'>
                          <Label className=''>Feche último contacto</Label>
                          <div className='relative'>
                            <Input
                              className='border-gray-400 focus-visible:ring-0 focus-visible:ring-offset-0 placeholder:text-gray-400'
                              placeholder={`${familia?.ingresoFa ? `${familia?.ingresoFa[2]}/${familia?.ingresoFa[1]}/${familia?.ingresoFa[0]}` : 'dd/mm/aaaa'}`}
                              disabled
                            />
                            <img src='/common/edit-2.svg' alt='borrar la familia' className='absolute top-2 right-2' />
                          </div>
                          <div className='relative'>
                            <Input
                              className='border-gray-400 focus-visible:ring-0 focus-visible:ring-offset-0 placeholder:text-gray-400'
                              placeholder={`${familia?.programaFundacionActual ? familia?.programaFundacionActual : 'Programa/Fundación Actual'}`}
                              disabled
                            />
                            <img src='/common/edit-2.svg' alt='borrar la familia' className='absolute top-2 right-2' />
                          </div>
                        </div>
                        <div className='relative flex flex-col gap-2'>
                          <Label className=''>Hijos biológicos</Label>
                          <div className='relative'>
                            <Input
                              className='border-gray-400 focus-visible:ring-0 focus-visible:ring-offset-0 placeholder:text-gray-400'
                              placeholder={'Nombre/s y (Edad/es)'}
                              disabled
                            />
                            <img src='/common/edit-2.svg' alt='borrar la familia' className='absolute top-2 right-2' />
                          </div>
                        </div>
                        <div className='relative flex flex-col gap-2'>
                          <Label className=''>Tiempo para coger una vez idónes</Label>
                          <div className='relative'>
                            <Input
                              className='border-gray-400 focus-visible:ring-0 focus-visible:ring-offset-0 placeholder:text-gray-400'
                              placeholder={''}
                              disabled
                            />
                            <img src='/common/edit-2.svg' alt='borrar la familia' className='absolute top-2 right-2' />
                          </div>
                          <div className='relative'>
                            <Input
                              className='border-gray-400 focus-visible:ring-0 focus-visible:ring-offset-0 placeholder:text-gray-400'
                              placeholder={`${familia?.cantidadAcogimientos ? familia?.cantidadAcogimientos : 'Cantidad de acogimientos'}`}
                              disabled
                            />
                            <img src='/common/edit-2.svg' alt='borrar la familia' className='absolute top-2 right-2' />
                          </div>
                        </div>
                        <div className='pb-2'>
                          <Button onClick={() => setCurrentForm(3)} type='button' variant='green' className='w-full'>Continuar</Button>
                        </div>
                      </section>
                      <section className={`${currentForm === 3 ? 'flex' : 'hidden'} flex-col gap-3 pt-4 md:pt-0`}>
                        <div className='relative flex flex-col gap-2'>
                          <Label className=''>Estado de acogimiento</Label>
                          <RadioGroup defaultValue={`${familia?.estadoAcogimiento ? familia?.estadoAcogimiento : ''}`}>
                            <div className='flex items-center space-x-2'>
                              <RadioGroupItem value='A' id='A' disabled />
                              <Label htmlFor='acogimento'>Acogiendo</Label>
                            </div>
                            <div className='flex items-center space-x-2'>
                              <RadioGroupItem value='SA' id='SA' disabled />
                              <Label htmlFor='acogimiento'>Sin Acogimiento</Label>
                            </div>
                            <div className='flex items-center space-x-2'>
                              <RadioGroupItem value='AP' id='AP' disabled />
                              <Label htmlFor='acogimiento'>Acogida Permanente</Label>
                            </div>
                          </RadioGroup>
                        </div>
                        <div className='relative flex flex-col gap-2'>
                          <Label className=''>Fecha inicio de Acogimiento</Label>
                          <div className='relative'>
                            <Input
                              className='border-gray-400 focus-visible:ring-0 focus-visible:ring-offset-0 placeholder:text-gray-400'
                              placeholder={'dd/mm/aaaa'}
                              disabled
                            />
                            <img src='/common/edit-2.svg' alt='borrar la familia' className='absolute top-2 right-2' />
                          </div>
                          <div className='relative'>
                            <Input
                              className='border-gray-400 focus-visible:ring-0 focus-visible:ring-offset-0 placeholder:text-gray-400'
                              placeholder={'Edad del NNA'}
                              disabled
                            />
                            <img src='/common/edit-2.svg' alt='borrar la familia' className='absolute top-2 right-2' />
                          </div>
                          <div className='relative'>
                            <Input
                              className='border-gray-400 focus-visible:ring-0 focus-visible:ring-offset-0 placeholder:text-gray-400'
                              placeholder={'Rango de edad'}
                              disabled
                            />
                            <img src='/common/edit-2.svg' alt='borrar la familia' className='absolute top-2 right-2' />
                          </div>
                          <div className='relative'>
                            <Input
                              className='border-gray-400 focus-visible:ring-0 focus-visible:ring-offset-0 placeholder:text-gray-400'
                              placeholder={'Sexo del NNA'}
                              disabled
                            />
                            <img src='/common/edit-2.svg' alt='borrar la familia' className='absolute top-2 right-2' />
                          </div>
                          <div className='relative'>
                            <Input
                              className='border-gray-400 focus-visible:ring-0 focus-visible:ring-offset-0 placeholder:text-gray-400'
                              placeholder={'Nacionalidad o pueblo Del NNA'}
                              disabled
                            />
                            <img src='/common/edit-2.svg' alt='borrar la familia' className='absolute top-2 right-2' />
                          </div>
                          <div className='relative'>
                            <Input
                              className='border-gray-400 focus-visible:ring-0 focus-visible:ring-offset-0 placeholder:text-gray-400'
                              placeholder={'Tiempo de acogimiento'}
                              disabled
                            />
                            <img src='/common/edit-2.svg' alt='borrar la familia' className='absolute top-2 right-2' />
                          </div>
                        </div>
                        <div className='relative flex flex-col gap-2'>
                          <Label className=''>Según la experiencia como familia de acogimiento, considerías:</Label>
                          <RadioGroup defaultValue=''>
                            <div className='flex items-center space-x-2'>
                              <RadioGroupItem value='mentoria' id='mentoria' disabled />
                              <Label htmlFor='mentoria'>Solicitar mentoría</Label>
                            </div>
                            <div className='flex items-center space-x-2'>
                              <RadioGroupItem value='mentora' id='mentora' disabled />
                              <Label htmlFor='mentora'>Postular como familia mentora</Label>
                            </div>
                            <div className='flex items-center space-x-2'>
                              <RadioGroupItem value='nada' id='nada' disabled />
                              <Label htmlFor='nada'>Por el momento ninguna de las anteriores</Label>
                            </div>
                          </RadioGroup>
                        </div>
                        <div className='pb-2'>
                          <Button type='submit' variant='orange' className='w-full'>Guardar Cambios</Button>
                        </div>
                      </section>
                    </>}
                  </div>
                </form>
              </Form>
            </>
          </div>
        </div>
      </section>
    </AppLayout>
  );
}
