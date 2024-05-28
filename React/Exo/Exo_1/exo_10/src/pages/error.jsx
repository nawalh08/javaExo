import { Link, Outlet } from "react-router-dom";
function Erreur() {
    return (
      <div className="App">
            <Link to={"/"}>HomePage</Link>
        <Link to={"/Toto"}>Toto</Link>
        <Link to={"/Titi"}>Titi</Link>
        <Link to={"/Photo"}>Photo</Link>
        <header className="App-header">
          <h1>Circulez il n'y a rien à voir ici</h1>
          <nav>
    
       
      </nav>
        </header>
      </div>
    );
  }
  
  export default Erreur;