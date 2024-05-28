import logo from './logo.svg';
import './App.css';
import TodoFormComponent from './Components/TodoFormComponent/TodoFormComponent';
import DisplayTodoComponent from './Components/DisplayTodoComponent/DisplayTodoComponent';
import { useState } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.min.js';

function App() {
  const [todolist,setList] = useState([])

  const addToList = (todo) => {       
   setList([...todolist,todo]) 
   console.log(todolist);
  }
  return (
    <div className="App">
    
        <TodoFormComponent addToList={addToList}/>
        <DisplayTodoComponent todolist={todolist} setList={setList}/>
     
    </div>
  );
}

export default App;
