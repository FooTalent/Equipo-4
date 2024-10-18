import * as yup from 'yup';

export const schemaCreateUser = yup.object({
  tipoUsuario: yup.string('Selecciona una opción').required('Selecciona una opción'),
  nombre: yup
    .string()
    .required('Introduce un nombre valido')
    .min(3, 'Un nombre no puede tener menos de 3 letras')
    .max(50, 'Un nombre no puede tener más que 50 letras')
    .matches(/^[a-zA-ZáéíóúÁÉÍÓÚñÑ\s]+$/, 'Un nombre solo puede tener letras'),
  apellido: yup
    .string()
    .required('Introduce un apellido valido')
    .min(2, 'Un apellido no puede tener menos de dos letras')
    .max(20, 'Un apellido no puede tener más que 20 letras')
    .matches(
      /^[a-zA-ZáéíóúÁÉÍÓÚñÑ\s]+$/,
      'Un apellido solo puede tener letras'
    ),
  correo: yup
    .string()
    .required('Introduce un correo valido')
    .email('Introduce un correo valido'),
  contrasenaHash:
    yup.string('Introduce contraseña valida')
      .required('Introduce contraseña valida')
      .min(8, 'Una contraseña tiene que tener un minimo de 8 caracteres')
      .max(35, 'Una contraseña no puede tener que tener más que 35 caracteres')
      .matches(
        /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&_])[A-Za-z\d@$!%*#?&_]{8,}$/,
        'La contraseña debe contener al menos una letra, un número y un carácter especial'),
  cargo: yup.string().nullable().min(3, 'Un cargo debe tener un minimo de 3 caracteres').max(25, 'Un cargo no debe tener más que 25 caracteres')
});
