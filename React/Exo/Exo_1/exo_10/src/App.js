import logo from './logo.svg';
import './App.css';
import ReactDOM from "react-dom/client";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Toto from './pages/Toto';
import Titi from './pages/titi';
import Photo from './pages/Photo';
import Erreur from './pages/error';

function App() {
  return (
    <div className="App">
      <header className="App-header">
      <BrowserRouter>
      <Routes>
        <Route path="/" element={<Titi />}>
          <Route index element={<App />} />
          <Route path="photo" element={<Photo />} />
          <Route path="toto" element={<Toto />} />
          <Route path="titi" element={<Titi />} />
          <Route path="*" element={<Erreur />} />
        </Route>
      </Routes>
    </BrowserRouter>
      </header>
    </div>
  );
}

export default App;
