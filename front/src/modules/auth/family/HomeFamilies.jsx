import { useEffect, useState } from 'react';
import comunas from '../../../../public/common/data/territoriochile.json';
import { useForm } from 'react-hook-form';
import { Button, Input, RadioGroup, RadioGroupItem } from '@/components/ui';
import useAuthStore from '@/store/user';
import { createFamily } from './api/createFamily';
export default function HomeFamilies() {
  const user = useAuthStore((state) => state.user);
  const { register, handleSubmit, setValue } = useForm();
  const [twoMembers, setTwoMembers] = useState(null);
  const [userData, setUserData] = useState(null);
  /*   const [familiesData, setFamiliesData] = useState([
    {
      id: 0,
      nombreFaUno: '',
      nombreFaDos: '',
      rutFaUno: '',
      rutFaDos: '',
      fechaNacimientoFaUno: '',
      fechaNacimientoFaDos: '',
      estadoCivil: '',
      telefono: '',
      email: '',
      region: '',
      comuna: '',
      direccion: '',
      ingresoFa: '',
      duracionEvaluacion: 0,
      tiempoParaAcoger: 0,
      cantidadAcogimientos: 0,
      fechaInicioAcogimiento: '',
      edadNna: 0,
      rangoEdadNna: '',
      sexoNna: '',
      nacionalidadNna: '',
      tiempoAcogimiento: 0,
      ingresoAfac: '',
      programaFundacionActual: '',
      programaFundacionAnterior: '',
      usuarioCreacion: '',
      fechaCreacion: '',
      fechaModificacion: '',
      estadoAcogimiento: '',
      usuario: '',
      fechaUltimoContacto: '',
    },
  ]); */
  const onSubmit = (data) => {
    const mappedData = {
      ...data,
      usuario: userData,
      fechaNacimientoFaUno: new Date(data.fechaNacimientoFaUno).toISOString(),
      fechaNacimientoFaDos: data.fechaNacimientoFaDos
        ? new Date(data.fechaNacimientoFaDos).toISOString()
        : null,
      ingresoFa: new Date(data.ingresoFa).toISOString(),
      ingresoAfac: new Date(data.ingresoAfac).toISOString(),
      fechaUltimoContacto: new Date(data.fechaUltimoContacto).toISOString(),
    };
    console.log(mappedData);
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
  }, []);

  return (
    <>
      <div
        id="home-families-container"
        className="w-[100%] min-h-screen bg-[#e6e6e6]"
      >
        <div
          id="home-families"
          className="flex items-center justify-center h-full"
        >
          <div
            id="home-families-content"
            className="pt-[25px] pr-[20px] pb-[25px] pl-[20px] w-[95%] flex justify-center"
          >
            <div
              id="home-families-form"
              className="bg-white rounded-[12px] pt-[20px] pr-[20px] pb-[25px] pl-[20px] w-[668px]"
            >
              <section
                id="home-families-form-title"
                className="flex-col w-full"
              >
                <h1 className="font-[400] text-2xl">Bienvenidos</h1>
              </section>
              <form
                id="home-families-form"
                className="flex flex-col w-full gap-10"
                onSubmit={handleSubmit(onSubmit)}
              >
                <section className="flex flex-col gap-5">
                  <div>
                    <h2 className="font-[500] text-1xl">
                      Datos personales del representante de familia
                    </h2>
                  </div>
                  <div className="w-full">
                    <label className="font-[500] text-1xl">
                      Cantidad de miembros representantes
                    </label>
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
                    name="nombreFaUno"
                    label="nombreFaUno"
                    placeholder="Nombre y Apellido Representante"
                    type="text"
                    onChange={handleInputChange}
                    {...register('nombreFaUno', {
                      required: true,
                      maxLength: 255,
                    })}
                  />
                  <Input
                    label="rutFaUno"
                    placeholder="RUT Representante"
                    type="text"
                    onChange={handleInputChange}
                    {...register('rutFaUno', {
                      required: true,
                      maxLength: 12,
                    })}
                  />
                  <div>
                    <label className="font-[500] text-1xl">
                      Fecha de Nacimiento Familiar
                    </label>
                    <Input
                      label="fechaNacimientoFaUno"
                      placeholder="Fecha de Nacimiento"
                      type="date"
                      onChange={handleInputChange}
                      {...register('fechaNacimientoFaUno')}
                    />
                  </div>
                  <Input
                    label="estadoCivil"
                    placeholder="Estado Civil"
                    type="text"
                    onChange={handleInputChange}
                    {...register('estadoCivil')}
                  />
                  <Input
                    label="telefono"
                    placeholder="Teléfono"
                    type="text"
                    onChange={handleInputChange}
                    {...register('telefono')}
                  />
                  <Input
                    label="email"
                    placeholder="Email"
                    type="text"
                    onChange={handleInputChange}
                    {...register('email')}
                  />
                  <Input
                    label="pais"
                    placeholder="Pais"
                    type="text"
                    onChange={handleInputChange}
                    {...register('pais')}
                  />
                  <Input
                    label="region"
                    placeholder="Ciudad"
                    type="text"
                    onChange={handleInputChange}
                    {...register('region')}
                  />
                  <select>
                    {comunas.map((comuna, index) => (
                      <option
                        key={index}
                        value={comuna}
                        onChange={handleInputChange}
                        {...register('comuna')}
                      >
                        {JSON.stringify(comuna.nombre)}
                      </option>
                    ))}
                  </select>
                  <Input
                    label="direccion"
                    placeholder="Dirección"
                    type="text"
                    onChange={handleInputChange}
                    {...register('direccion')}
                  />
                </section>
                {/*Miembro dos*/}
                {twoMembers && (
                  <section className="flex flex-col gap-5">
                    <h2 className="font-[500] text-1xl">
                      Segundo Representante
                    </h2>
                    <Input
                      label="nombreFaUno"
                      placeholder="Nombre y Apellido Representante"
                      type="text"
                      onChange={handleInputChange}
                      {...register('nombreFaDos', {
                        required: true,
                        maxLength: 255,
                      })}
                    />
                    <Input
                      label="rutFaDos"
                      placeholder="RUT Representante"
                      type="text"
                      onChange={handleInputChange}
                      {...register('rutFaDos', {
                        required: true,
                        maxLength: 12,
                      })}
                    />
                    <div>
                      <label className="font-[500] text-1xl">
                        Fecha de Nacimiento Familiar
                      </label>
                      <Input
                        label="fechaNacimientoFaDos"
                        placeholder="Fecha de Nacimiento"
                        type="date"
                        onChange={handleInputChange}
                        {...register('fechaNacimientoFaDos')}
                      />
                    </div>
                  </section>
                )}
                {/*Miembro dos*/}
                <div className="flex flex-col gap-5">
                  <section>
                    <div>
                      <h2 className="font-[500] text-1xl">
                        Estado acogimiento
                      </h2>
                    </div>
                    <RadioGroup>
                      <div className="flex items-center gap-2">
                        <RadioGroupItem value="acogiendo" />
                        <label
                          value="estadoAcogimiento"
                          className="text-sm"
                          onChange={handleInputChange}
                          {...register('acogiendo')}
                        >
                          Acogiendo
                        </label>
                      </div>
                      <div className="flex items-center gap-2">
                        <RadioGroupItem value="sinAcogimiento" />
                        <label
                          value="estadoAcogimiento"
                          className="text-sm"
                          onChange={handleInputChange}
                          {...register('sinAcogimiento')}
                        >
                          Sin Acogimiento
                        </label>
                      </div>
                      <div className="flex items-center gap-2">
                        <RadioGroupItem value="acogidaPermanente" />
                        <label
                          value="estadoAcogimiento"
                          className="text-sm"
                          onChange={handleInputChange}
                          {...register('acogidaPermanente')}
                        >
                          Acogida Permanente
                        </label>
                      </div>
                    </RadioGroup>
                  </section>
                  <section>
                    <div>
                      <h2 className="font-[500] text-1xl">
                        ¿Ya tienes asignado algún rol como familia voluntaria en
                        AFAC? Si es así, ¿nos podrías indicar cuál es?
                      </h2>
                    </div>
                    <Input
                      label="RolAfac"
                      type="text"
                      placeholder="Rol como voluntario en AFAC"
                      onChange={handleInputChange}
                      {...register('RolAfac')}
                    />
                  </section>
                  <section>
                    <div>
                      <h2 className="font-[500] text-1xl">
                        Según la experiencia como familia de acogimiento,
                        considerarías:
                      </h2>
                    </div>
                    <RadioGroup>
                      <div className="flex items-center gap-2">
                        <RadioGroupItem value="experenciaAcogimiento" />
                        <label
                          value="estadoAcogimiento"
                          className="text-sm"
                          onChange={handleInputChange}
                          {...register('experenciaAcogimiento')}
                        >
                          Solicitar mentoría
                        </label>
                      </div>
                      <div className="flex items-center gap-2">
                        <RadioGroupItem value="familiaVoluntaria" />
                        <label
                          value="experenciaAcogimiento"
                          className="text-sm"
                          onChange={handleInputChange}
                          {...register('experenciaAcogimiento')}
                        >
                          Postular como familia voluntaria
                        </label>
                      </div>
                      <div className="flex items-center gap-2">
                        <RadioGroupItem value="ninguna" />
                        <label
                          value="experenciaAcogimiento"
                          className="text-sm"
                          onChange={handleInputChange}
                          {...register('experenciaAcogimiento')}
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
    </>
  );
}
