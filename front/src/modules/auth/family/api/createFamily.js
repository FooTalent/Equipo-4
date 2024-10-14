import axios from 'axios';
import { AxiosBase } from '@/common/axios';

export const createFamily = async (values) => {
  try {
    const response = await AxiosBase.post('/api/familias', values);
    return response.data;
  } catch (error) {
    return axios.isAxiosError(error) &&
      error.status >= 400 &&
      error.status < 500
      ? 'Se necesitan las credenciales correctas'
      : 'Un error ha ocurrido';
  }
};
