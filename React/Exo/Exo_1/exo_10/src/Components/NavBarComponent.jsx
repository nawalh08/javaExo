

      import { Link, Outlet } from "react-router-dom";

const NavBar = () => {
  return ( 
    <>
      <nav>
        <Link to={"/"}>HomePage</Link>
        <Link to={"/Toto"}>Toto</Link>
        <Link to={"/Titi"}>Titi</Link>
        <Link to={"/Photo"}>Photo</Link>
       
      </nav>
      <div>
        <Outlet />
      </div>
      <footer>Mon pied de page</footer>
    </>
   );
}
 
export default NavBar;