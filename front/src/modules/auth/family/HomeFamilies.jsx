import Footer from "@/components/shared/footer";
import Navbar from "@/components/shared/navbar";
import { Button, Input, RadioGroup, RadioGroupItem } from "@/components/ui";
import React from "react";
export default function HomeFamilies() {
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
                <h1>Bienvenidos</h1>
              </section>
              <form
                id="home-families-form"
                className="flex flex-col w-full gap-10"
              >
                <section className="flex flex-col gap-5">
                  <div>
                    <h2>Datos Personales</h2>
                  </div>
                  <Input
                    label="nombreFaUno"
                    placeholder="Nombre y Apellido"
                    type="text"
                  />
                  <Input label="rutFaUno" placeholder="RUT" type="text" />
                  <Input
                    label="fechaNacimientoFaUno"
                    placeholder="Fecha de Nacimiento"
                    type="date"
                  />
                  <Input
                    label="estadoCivil"
                    placeholder="Estado Civil"
                    type="text"
                  />
                  <Input label="telefono" placeholder="Teléfono" type="text" />
                  <Input label="email" placeholder="Email" type="text" />
                  <Input label="Pais" placeholder="Pais" type="text" />
                  <Input label="region" placeholder="Ciudad" type="text" />
                  <Input label="comuna" placeholder="Comuna" type="text" />
                  <Input
                    label="direccion"
                    placeholder="Dirección"
                    type="text"
                  />
                </section>
                <div className="flex flex-col gap-5">
                  <div>
                    <h2>Datos de familia de Acogimiento</h2>
                  </div>
                  <section>
                    <div>
                      <h2>Fecha de ingreso a AFAC</h2>
                    </div>
                    <Input label="ingresoAfac" type="date" />
                  </section>
                  <section>
                    <div>
                      <h2>Fecha de ingreso como FA</h2>
                    </div>
                    <Input label="ingresoFa" type="date" />
                  </section>
                  <section className="flex flex-col gap-5">
                    <div>
                      <h2>Fecha de último contacto</h2>
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
                      <h2>Hijos Biológicos</h2>
                    </div>
                    <Input
                      label="hijosBiologicos"
                      type="text"
                      placeholder="Nombres/s y (Edad/es)"
                    />
                  </section>
                  <section>
                    <div>
                      <h2>¿Cuánto duró el período de evaluación?</h2>
                    </div>
                    <Input label="duracionEvaluacion" type="text" />
                  </section>
                  <section>
                    <div>
                      <h2>Tiempo para acoger una vez idóneos</h2>
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
                      <h2>Estado acogimiento</h2>
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
                  <section>
                    <div>
                      <h2>Fecha de inicio de Acogimeinto</h2>
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
                      <h2>
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
                      <h2>
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
                    className="w-full py-3 text-base text-center text-black bg-orange-400 rounded-md md:w-3/4 hover:bg-orange-500 hover:opacity-80"
                  >
                    Enviar
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
