import React from 'react';
import { useState } from 'react';

const FizzBuzzComponent = () => {

  const [mot, setMot] = useState("")
  const [cpt, setCpt] = useState(0)
  

  const changeMot = () => {
    
    if(cpt%3==0 && cpt%5==0 && cpt!=0 ){
        return "FizzBuzz"
    }else if(cpt%5==0 && cpt!=0  ){
        return "Buzz"
    }else if(cpt%3==0 && cpt!=0  ){
        return "Fizz"
    }else{
        return(cpt)
    }
  }

  const increase =() =>{
    setCpt(cpt+1)
    console.log(cpt+1);
   
  
  }
  const decrease =() =>{
    setCpt(cpt-1)
    console.log(cpt+1);
   
  }
 

  return ( 
    <div>
    <h1>StateLessComponent</h1>
    <p>{cpt}</p>
    <button disabled={cpt==60} onClick={increase}>+</button>
    <button  disabled={cpt==0} onClick={decrease}>-</button>
    <p>Valeur : {changeMot()}</p>
  </div>
   );
}

 
export default FizzBuzzComponent;