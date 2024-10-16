import axios from 'axios';

const BASE_URL = import.meta.env.VITE_APP_API_URL || 'http://localhost:8081/api';

export const AxiosBase = axios.create({
  baseURL: BASE_URL,
  withCredentials: true
});