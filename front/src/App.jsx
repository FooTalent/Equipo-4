import { Link } from 'react-router-dom';
import './App.css';
import './index.css';

function App() {

  return (
    <Link to={'/auth'}>Inicia sesión</Link>
  );
}

export default App;
