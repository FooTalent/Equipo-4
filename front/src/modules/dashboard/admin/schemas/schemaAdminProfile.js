import * as yup from 'yup';

export const schemaAdminProfile = yup.object({
  nombre: yup
    .string()
    .required('Introduce un nombre valido')
    .min(2, 'Un nombre no puede tener menos de dos letras')
    .max(20, 'Un nombre no puede tener más que 20 letras')
    .matches(
      /^[a-zA-ZáéíóúÁÉÍÓÚñÑ\s]+$/,
      'Un nombre solo puede tener letras'
    ),
  apellido: yup
    .string()
    .required('Introduce un apellido valido')
    .min(2, 'Un apellido no puede tener menos de dos letras')
    .max(20, 'Un apellido no puede tener más que 20 letras')
    .matches(
      /^[a-zA-ZáéíóúÁÉÍÓÚñÑ\s]+$/,
      'Un apellido solo puede tener letras'
    ),
  correo:
    yup.string()
      .required('Introduce un correo valido')
      .email('Introduce un correo valido'),
});