import React from 'react';
import { useState } from 'react';

const FormComponent = (props) => {

 const {addToList} = props
  const [firstname, setfirstname] = useState("")
  const [lastname, setlastname] = useState("")
  const [email, setemail] = useState("")
  
    function handleInputFirst(e){
        setfirstname(e.target.value)
        
    }
    function handleInputLast(e){
        setlastname(e.target.value)
        
    }
    function handleInputEmail(e){
        setemail(e.target.value)
        
    }

    function createPerson(){
       let Person = {firstname:firstname,lastname:lastname,email:email}
       addToList(Person)
    }
 

  return ( 
    <div>
    <input type='text' value={lastname} onInput={handleInputLast} ></input>
    <input type='text' value={firstname} onInput={handleInputFirst}></input>
    <input type='text' value={email} onInput={handleInputEmail}></input>
    <button disabled={lastname=="" || firstname=="" || email==""} onClick={createPerson}>AddPerson</button>
  </div>
   );
}

 
export default FormComponent;