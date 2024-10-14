import { useState } from 'react';
import Footer from '@/components/shared/footer';
import Navbar from '@/components/shared/navbar';
import comunas from '../../../../public/common/data/territoriochile.json';
import { useForm } from 'react-hook-form';

import { Button, Input, RadioGroup, RadioGroupItem } from '@/components/ui';
export default function HomeFamilies() {
  const { register, handleSubmit } = useForm();
  const [twoMembers, setTwoMembers] = useState(null);
  const [familiesData, setFamiliesData] = useState([
    {
      nombreFaUno: '',
      rutFaUno: '',
      estadoCivilFaUno: '',
      telefono: '',
      email: '',
      pais: '',
      region: '',
      direccion: '',
      ingresoAfa: '',
      fechaUltimoContacto: '',
      nacionalidadNna: '',
      programaFundacionActual: '',
      hijosBiologicos: '',
      duracionEvaluacion: '',
      edadNna: '',
    },
  ]);
  const onSubmit = (data) => {
    console.log(data);
  };

  return (
    <>
      {/*RECORDAR DE BORRAR*/}
      <Navbar />
      {/*RECORDAR DE BORRAR*/}
      <div
        id="home-families-container"
        className="w-full min-h-screen bg-[#e6e6e6]"
      >
        <div
          id="home-families"
          className="flex items-center justify-center w-full h-full"
        >
          <div
            id="home-families-content"
            className="pt-[25px] pr-[20px] pb-[25px] pl-[20px]"
          >
            <div
              id="home-families-form"
              className="bg-white rounded-[12px] pt-[20px] pr-[20px] pb-[25px] pl-[20px] w-[668px]"
            >
              <section
                id="home-families-form-title"
                className="flex-col w-full"
              >
                <h1 className='font-[400] text-2xl'>Bienvenidos</h1>
              </section>
              <form
                id="home-families-form"
                className="flex flex-col w-full gap-10"
                onSubmit={handleSubmit(onSubmit)}
              >
                <section className="flex flex-col gap-5">
                  <div>
                    <h2 className='font-[500] text-1xl'>Datos personales del representante de familia</h2>
                  </div>
                  <div className="w-full">
                    <label className='font-[500] text-1xl'>Cantidad de miembros representantes</label>
                    <select
                      className="w-full"
                      value={twoMembers ? '2' : '1'}
                      onChange={(e) => setTwoMembers(e.target.value === '2')}
                    >
                      <option value="1">1</option>
                      <option value="2">2</option>
                    </select>
                  </div>
                  <Input
                    label="nombreFaUno"
                    placeholder="Nombre y Apellido Representante"
                    type="text"
                    {...register('nombreFaUno', {
                      required: true,
                      maxLength: 255,
                    })}
                  />
                  <Input
                    label="rutFaUno"
                    placeholder="RUT Representante"
                    type="text"
                  />
                  <div>
                    <label className='font-[500] text-1xl'>Fecha de Nacimiento Familiar</label>
                    <Input
                      label="fechaNacimientoFaUno"
                      placeholder="Fecha de Nacimiento"
                      type="date"
                    />
                  </div>
                  <Input
                    label="estadoCivil"
                    placeholder="Estado Civil"
                    type="text"
                  />
                  <Input label="telefono" placeholder="Teléfono" type="text" />
                  <Input label="email" placeholder="Email" type="text" />
                  <Input label="pais" placeholder="Pais" type="text" />
                  <Input label="region" placeholder="Ciudad" type="text" />
                  <select>
                    {comunas.map((comuna, index) => (
                      <option key={index} value={comuna}>
                        {JSON.stringify(comuna.nombre)}
                      </option>
                    ))}
                  </select>
                  <Input
                    label="direccion"
                    placeholder="Dirección"
                    type="text"
                  />
                </section>
                {/*Miembro dos*/}
                {twoMembers && (
                  <section className="flex flex-col gap-5">
                    <h2 className='font-[500] text-1xl'>Segundo Representante</h2>
                    <Input
                      label="nombreFaUno"
                      placeholder="Nombre y Apellido Representante"
                      type="text"
                      {...register('nombreFaDos', {
                        required: true,
                        maxLength: 255,
                      })}
                    />
                    <Input
                      label="rutFaDos"
                      placeholder="RUT Representante"
                      type="text"
                    />
                    <div>
                      <label className='font-[500] text-1xl'>Fecha de Nacimiento Familiar</label>
                      <Input
                        label="fechaNacimientoFaDos"
                        placeholder="Fecha de Nacimiento"
                        type="date"
                      />
                    </div>
                    <Input
                      label="estadoCivil"
                      placeholder="Estado Civil"
                      type="text"
                    />
                    <Input
                      label="telefono"
                      placeholder="Teléfono"
                      type="text"
                    />
                    <Input label="email" placeholder="Email" type="text" />
                    <Input label="pais" placeholder="Pais" type="text" />
                    <Input label="region" placeholder="Ciudad" type="text" />
                    <select>
                      {comunas.map((comuna, index) => (
                        <option key={index} value={comuna}>
                          {JSON.stringify(comuna.nombre)}
                        </option>
                      ))}
                    </select>
                    <Input
                      label="direccion"
                      placeholder="Dirección"
                      type="text"
                    />
                  </section>
                )}
                {/*Miembro dos*/}
                <div className="flex flex-col gap-5">
                  <div>
                    <h2 className='font-[500] text-1xl'>
                      Datos de familia de Acogimiento (completar los siguientes
                      datos junto a un asesor de AFAC en su próxima llamada de
                      seguimiento)
                    </h2>
                  </div>
                  <section>
                    <div>
                      <h2 className='font-[500] text-1xl'>Fecha de ingreso a AFAC</h2>
                    </div>
                    <Input label="ingresoAfac" type="date" />
                  </section>
                  <section>
                    <div>
                      <h2 className='font-[500] text-1xl'>Fecha de ingreso a un programa como FA</h2>
                    </div>
                    <Input label="ingresoFa" type="date" />
                  </section>
                  <section className="flex flex-col gap-5">
                    <div>
                      <h2 className='font-[500] text-1xl'>Fecha de última llamada de seguimiento</h2>
                    </div>
                    <Input label="fechaUltimoContacto" type="date" />
                    <Input
                      label="nacionalidadNna"
                      type="text"
                      placeholder="Nacionalidad"
                    />
                    <Input
                      label="programaFundacionActual"
                      type="text"
                      placeholder="Programa/Fundación Actual"
                    />
                  </section>
                  <section>
                    <div>
                      <h2 className='font-[500] text-1xl'>Hijos Biológicos</h2>
                    </div>
                    <Input
                      label="hijosBiologicos"
                      type="text"
                      placeholder="Nombres/s y (Edad/es)"
                    />
                  </section>
                  <section>
                    <div>
                      <h2 className='font-[500] text-1xl'>¿Cuánto duró el período de evaluación?</h2>
                    </div>
                    <Input label="duracionEvaluacion" type="text" />
                  </section>
                  <section className="flex flex-col gap-5">
                    <div>
                      <h2 className='font-[500] text-1xl'>Tiempo para acoger una vez idóneos</h2>
                    </div>
                    <Input label="tiempoParaAcoger" type="text" />
                    <Input
                      label="cantidadAcogimientos"
                      type="text"
                      placeholder="Cantidad de Acogimientos"
                    />
                  </section>
                  <section>
                    <div>
                      <h2 className='font-[500] text-1xl'>Estado acogimiento</h2>
                    </div>
                    <RadioGroup>
                      <div className="flex items-center gap-2">
                        <RadioGroupItem value="acogiendo" />
                        <label value="estadoAcogimiento" className="text-sm">
                          Acogiendo
                        </label>
                      </div>
                      <div className="flex items-center gap-2">
                        <RadioGroupItem value="sinAcogimiento" />
                        <label value="estadoAcogimiento" className="text-sm">
                          Sin Acogimiento
                        </label>
                      </div>
                      <div className="flex items-center gap-2">
                        <RadioGroupItem value="acogidaPermanente" />
                        <label value="estadoAcogimiento" className="text-sm">
                          Acogida Permanente
                        </label>
                      </div>
                    </RadioGroup>
                  </section>
                  <section className="flex flex-col gap-5">
                    <div>
                      <h2 className='font-[500] text-1xl'>Fecha de inicio de Acogimeinto</h2>
                    </div>
                    <Input label="fechaInicioAcogimiento" type="date" />
                    <Input
                      label="edadNna"
                      type="text"
                      placeholder="Edad del NNA"
                    />
                    <Input
                      label="rangoEdadNna"
                      type="text"
                      placeholder="Rango de edad"
                    />
                    <Input
                      label="sexoNna"
                      type="text"
                      placeholder="Sexo del NNA"
                    />
                    <Input
                      label="nacionalidadNna"
                      type="text"
                      placeholder="Nacionalidad o pueblo del NNA"
                    />
                    <Input
                      label="tiempoAcogimiento"
                      type="text"
                      placeholder="Tiempo de Acogimiento"
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
                      label="RolAfac"
                      type="text"
                      placeholder="Rol como voluntario en AFAC"
                    />
                  </section>
                  <section>
                    <div>
                      <h2 className='font-[500] text-1xl'>
                        Según la experiencia como familia de acogimiento,
                        considerarías:
                      </h2>
                    </div>
                    <RadioGroup>
                      <div className="flex items-center gap-2">
                        <RadioGroupItem value="experenciaAcogimiento" />
                        <label value="estadoAcogimiento" className="text-sm">
                          Solicitar mentoría
                        </label>
                      </div>
                      <div className="flex items-center gap-2">
                        <RadioGroupItem value="familiaVoluntaria" />
                        <label
                          value="experenciaAcogimiento"
                          className="text-sm"
                        >
                          Postular como familia voluntaria
                        </label>
                      </div>
                      <div className="flex items-center gap-2">
                        <RadioGroupItem value="ninguna" />
                        <label
                          value="experenciaAcogimiento"
                          className="text-sm"
                        >
                          Por el mokmento ninguna de las anteriores
                        </label>
                      </div>
                    </RadioGroup>
                  </section>
                </div>
                <div className="flex justify-center">
                  <Button
                    type="submit"
                    className="w-full py-3 text-base font-bold text-center text-black bg-orange-400 rounded-md md:w-3/4 hover:bg-orange-500 hover:opacity-80"
                  >
                    Guardar Cambios
                  </Button>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
      {/*RECORDAR DE BORRAR*/}
      <Footer />
      {/*RECORDAR DE BORRAR*/}
    </>
  );
}
