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

export const createUserApi = async (values) => {
  try {
    const response = await AxiosBase.post('/auth/register', values);
    return response.data;
  } catch (error) {
    return axios.isAxiosError(error) &&
      error.status >= 400 &&
      error.status < 500
      ? 'No se pudo crear el usuario'
      : 'Un error ha ocurrido';
  }
};

export const sendUserDataApi = async (values) => {
  const { correo, contrasenaHash } = values;
  try {
    const response = await AxiosBase.post(`/email/mensaje-registro?email=${correo}`, { contrasenaHash });
    return response.data;
  } catch (error) {
    return axios.isAxiosError(error) &&
      error.status >= 400 &&
      error.status < 500
      ? 'No se pudo crear el usuario'
      : 'Un error ha ocurrido';
  }
};

export const getAllFamiliesApi = async () => {
  try {
    const response = await AxiosBase.get(
      '/familias'
    );
    return response.data;
  } catch (error) {
    return axios.isAxiosError(error) &&
      error.status >= 400 &&
      error.status < 500
      ? 'No se pudo acceder al listado de familia'
      : 'Un error ha ocurrido';
  }
};

export const getAdminNotification = async (user_id) => {
  try {
    const response = await AxiosBase.get(`/notificaciones/${user_id}`);
    return response.data;
  } catch (error) {
    return axios.isAxiosError(error) &&
      error.status >= 400 &&
      error.status < 500
      ? 'No se pudo leer las notificaciones'
      : 'Un error ha ocurrido';
  }
};

export const getAllMentoringApi = async () => {
  try {
    const response = await AxiosBase.get(
      '/mentorias'
    );
    return response.data;
  } catch (error) {
    return axios.isAxiosError(error) &&
      error.status >= 400 &&
      error.status < 500
      ? 'No se pudo acceder al listado de mentorias'
      : 'Un error ha ocurrido';
  };
};

export const getFamilyByIdApi = async (id) => {
  try {
    const response = await AxiosBase.get(
      `/familias/${id}`
    );
    return response.data;
  } catch (error) {
    return axios.isAxiosError(error) &&
      error.status >= 400 &&
      error.status < 500
      ? 'No se pudo acceder al listado de familia'
      : 'Un error ha ocurrido';
  }
};

export const getAllUsers = async () => {
  try {
    const response = await AxiosBase.get(
      '/usuarios'
    );
    return response.data;
  } catch (error) {
    return axios.isAxiosError(error) &&
      error.status >= 400 &&
      error.status < 500
      ? 'No se pudo acceder al listado de usuarios'
      : 'Un error ha ocurrido';
  }
};

export const getAllVolunteersApi = async () => {
  try {
    const response = await AxiosBase.get('/voluntarios');
    return response.data;
  } catch (error) {
    return axios.isAxiosError(error) &&
      error.status >= 400 &&
      error.status < 500
      ? 'No se pudo acceder al listado de voluntarios'
      : 'Un error ha ocurrido';
  }
};

export const searchFamiliesApi = async (values) => {
  try {
    const response = await AxiosBase.post(`/familias/buscar?nombre=${values?.nombre}`);
    return response.data;
  } catch (error) {
    return axios.isAxiosError(error) &&
      error.status >= 400 &&
      error.status < 500
      ? 'No se pudo encontrar la familia'
      : 'Un error ha ocurrido';
  }
};

export const sendGeneralEmailApi = async (values) => {
  const { destinatarios, asunto, mensaje } = values;
  try {
    const response = await AxiosBase.post('/api/email/general', {
      destinatarios,
      asunto,
      mensaje
    });
    return response.data;
  } catch (error) {
    return axios.isAxiosError(error) &&
    error.status >= 400 &&
    error.status < 500
        ? 'No se pudo enviar el email'
        : 'Un error ha ocurrido';
  }
};