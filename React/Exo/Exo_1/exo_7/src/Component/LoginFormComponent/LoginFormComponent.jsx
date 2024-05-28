

import React, { useRef } from 'react';
import { useState } from 'react';

const LoginFormComponent = (props) => {

  const {Recup} = props
  const ValidUser = "Fares";
  const ValidPassword = "Dries";
  const usernameRef = useRef("");
  const passwordRef = useRef("");


  function Verify (){
    Recup(usernameRef.current.value,passwordRef.current.value)
    if(usernameRef.current.value != ValidUser || passwordRef.current.value != ValidPassword){
        console.log("Erreur le mot de passe ou l'utilisateur est incorrect");
    }else{
        console.log("Bienvenue " + usernameRef.current.value);
    }
  }

  return ( 
    <div>
    <input type='text'  ref={usernameRef} ></input>
    <input type='text'  ref={passwordRef} ></input>
    <button onClick={Verify}>Validate</button>
  </div>
   );
}
export default LoginFormComponent