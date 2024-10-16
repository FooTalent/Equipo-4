import axios from 'axios';
import { AxiosBase } from '@/common/axios';

export const loginFamilyApi = async(values) => {
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

export const personalizeFamilyApi = async(values) => {
  const { correo, contrasenaHash } = values;
  try {
    const response = await AxiosBase.put(`/auth/password?email=${correo}`, { contrasenaHash });
    return response.data;
  } catch (error) {
    return axios.isAxiosError(error) && (error.status >= 400 && error.status < 500) ? 'No se pudo actualizar la contraseña' : 'Un error ha ocurrido';
  }
};

export const forgotPasswordFamilyApi = async(values) => {
  const { email } = values;
  try {
    const response = await AxiosBase.post(
      `/auth/solicitar-recuperar-password?email=${email}`
    );
    return response.data;
  } catch (error) {
    if (axios.isAxiosError(error)) {
      if (error.response?.status >= 400 && error.response?.status < 500) {
        return 'No se pudo procesar la solicitud de recuperación de contraseña';
      }
    }
    return 'Un error ha ocurrido';
  }
};

export const resetPasswordFamilyApi = async(values) => {
  const { contrasenaHash, resetToken } = values;
  try {
    const response = await AxiosBase.post(`/auth/reset-password/${resetToken}`, { contrasenaHash });
    return response.data;
  } catch (error) {
    if (axios.isAxiosError(error)) {
      if (error.response?.status >= 400 && error.response?.status < 500) {
        return 'No se pudo restablecer la contraseña';
      }
    }
    return 'Un error ha ocurrido';
  }
};
