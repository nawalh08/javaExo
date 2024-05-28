import {createBrowserRouter} from "react-router-dom"
import Toto from './pages/Toto';
import Titi from './pages/titi';
import Photo from './pages/Photo';
import Erreur from './pages/error';
import NavBar from "./Components/NavBarComponent";

const router = createBrowserRouter([
  // {path: '/', element: <HomePage />, errorElement: <ErrorPage/>},
  // {path: '/form', element: <FormPage />, errorElement: <ErrorPage/>}
  {
    path: "/",
    element: <NavBar />,
    errorElement: <Erreur />,
    children: [
      {path: '/', element: <Toto />},
      {path: '/Toto', element: <Toto />},
      {path: '/Titi', element: <Titi />},
      {path: '/Photo', element: <Photo />}
    ]
  }
])

export default router