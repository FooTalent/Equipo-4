import axios from 'axios';
import { AxiosBase } from '@/common/axios';

export const adminProfileApi = async (values) => {
  const { id, nombre, apellido, correo } = values;
  try {
    const response = await AxiosBase.put(`/usuarios/${id}`, { nombre, apellido, correo });
    return response.data;
  } catch (error) {
    return axios.isAxiosError(error) && error.status >= 400 && error.status < 500
      ? 'No se pudo actualizar su perfil'
      : 'Un error ha ocurrido';
  }
};