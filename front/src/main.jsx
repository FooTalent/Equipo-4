import { StrictMode } from 'react';
import { createRoot } from 'react-dom/client';
import './index.css';
import Router from './routes/index.jsx';
import ReactQueryProvider from './common/react-query-provider';
import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

createRoot(document.getElementById('root')).render(
  <StrictMode>
    <ReactQueryProvider>
      <Router />
      <ToastContainer />
    </ReactQueryProvider>
  </StrictMode>,
);
