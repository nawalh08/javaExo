import { useState, useEffect,useRef } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import axios from 'axios'
import CountryItemDisplay from './Components/CountryItemDisplay'
import 'bootstrap/dist/css/bootstrap.min.css';  

function App() {
  const [toggle, setToggle] = useState(false)
  const [country,setCountry] = useState([])
  const searchRef = useRef("")
  useEffect(() => {
    axios.get("https://restcountries.com/v3.1/all")
      .then((response) => {
        console.log(response);
        setCountry(response.data)
        
    }).catch(error => console.error(error))
},[] )

function reload(){
  if(searchRef.current.value ===""){
  axios.get("https://restcountries.com/v3.1/all")
  .then((response) => {
    console.log(response);
    setCountry(response.data)
    
}).catch(error => console.error(error))
  }else{
    axios.get("https://restcountries.com/v3.1/name/" + searchRef.current.value)
  .then((response) => {
    console.log(response);
    setCountry(response.data)
    
}).catch(error => console.error(error))
  }

}

console.log(country);


  return (
    <>
    <h1 style={{ width: '100%', marginBottom:'5rem', textAlign:'center'}}>Liste de Pays</h1>
    <div>
    <input type='text' style={{ width: '100%', marginBottom:'5rem', marginTop:'5rem'}} placeholder="Rechercher"ref={searchRef} onChange={reload}></input>

    </div>
      <div className="row">
        
      {country.map((t ,index) => <CountryItemDisplay key={index} country={t}/>)}
        
      </div>
      
      
     
    </>
  )
}

export default App
