import axios from 'axios';
import { AxiosBase } from '@/common/axios';

export const createFamily = async (values) => {
  try {
    const response = await AxiosBase.post('/familias', values);
    console.log(response);
    return response.data;
  } catch (error) {
    console.log(error);
    return axios.isAxiosError(error) &&
      error.status >= 400 &&
      error.status < 500
      ? 'Se necesitan las credenciales correctas'
      : 'Un error ha ocurrido';
  }
};
