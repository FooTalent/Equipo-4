import axios from 'axios';
import { AxiosBase } from '@/common/axios';

export const loginAdminApi = async(values) => {
  try {
    const response = await AxiosBase.post(
      '/auth/login',
      values
    );
    return response.data;
  } catch (error) {
    return axios.isAxiosError(error) && (error.status >= 400 && error.status < 500) ? 'Se necesitan las credenciales correctas' : 'Un error ha ocurrido';
  }
};

export const personalizeAdminApi = async(values) => {
  const { correo, contrasenaHash } = values;
  try {
    const response = await AxiosBase.put(`/auth/password?email=${correo}`, { contrasenaHash });
    return response.data;
  } catch (error) {
    return axios.isAxiosError(error) && (error.status >= 400 && error.status < 500) ? 'No se pudo actualizar la contraseña' : 'Un error ha ocurrido';
  }
};
