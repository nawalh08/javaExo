

import React, { useRef } from 'react';
import { useState } from 'react';

const TodoFormComponent = (props) => {

  const [id, setId] = useState(0)
  const {addToList} = props
  
  const TodoNameRef = useRef("");
  const DescriptionTodoRef = useRef("");
  const DateTodoRef = useRef("");
  const todoStatus = useRef(false)

  function AddTodo(){
    if (TodoNameRef.current.value=="" || DescriptionTodoRef.current.value=="" || DateTodoRef.current.value==""){
      alert("Veuillez enter un élément dans tout les champs requis")
    }else{
      let Todo = {id:id,TodoName:TodoNameRef.current.value,Description:DescriptionTodoRef.current.value,DateTodo:DateTodoRef.current.value}
      addToList(Todo)
      setId(id+1)
    }
  }

 

  return ( 
    <div className='card text-white bg-dark mb-5' >
      <p>Title</p>
    <input type='text'ref={TodoNameRef} ></input>
    <p>Description</p>
    <input type='textarea'ref={DescriptionTodoRef} ></input>
    <p>DueDate</p>
    <input type='date'ref={DateTodoRef} ></input>
    <button  onClick={AddTodo}>Validate</button>
  </div>
   );
}
export default TodoFormComponent