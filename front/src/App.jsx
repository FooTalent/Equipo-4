import { useEffect } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import './App.css';
import './index.css';

function App() {
  const navigate = useNavigate();
  useEffect(() => {
    navigate('/auth');
  }, [navigate]);
  return (
    <Link to={'/auth'}>Inicia sesión</Link>
  );
}

export default App;
