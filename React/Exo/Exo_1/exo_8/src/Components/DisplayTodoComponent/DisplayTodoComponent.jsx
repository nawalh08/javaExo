

import React, { useRef } from 'react';
import { useState } from 'react';

const DisplayTodoComponent = (props) => {

  const {todolist,setList} = props
  
  function handleDeleteClick(id) {
    // here we are filtering - the idea is remove an item from the todo array on a button click
     const removeItem = todolist.filter((todo) => {
      // return the rest of the todos that don't match the item we are deleting
      return todo.id !== id;
    });
    // removeItem returns a new array - so now we are setting the todos to the new array
    setList(removeItem)
    
  }
  const [isDone, setIsDone] = useState({})


  const handleToggle = (index) => {
    setIsDone({
        ...isDone,
        [index]: !isDone[index],

    });
};
  

 

 

  return ( 
    <div>
    <table className="table table-dark">
      <thead>
        <tr>
          <th>#</th>
          <th>Firstname</th>
          <th>Lastname</th>
          <th>Email</th>
          <th>Status</th>
          <th>Delete</th>
        </tr>
      </thead>
      <tbody>
        {
          todolist.map((e, index) => (
            <tr key={index}>
              <td>{e.id}</td>
              <td>{e.TodoName}</td>
              <td>{e.Description}</td>
              <td>{e.DateTodo}</td>              
              <td><button  onClick={() => handleToggle(index)} class={isDone[index]?"btn btn-success":"btn btn-warning"}>{isDone[index] ? "Done" : "To Do"}</button>  </td>
              <td><button class="btn btn-danger"onClick={() => handleDeleteClick(e.id)}>Delete</button></td>
            </tr>
          ))
        }
      </tbody>
    </table>
  </div>
   );
}
export default DisplayTodoComponent