import logo from './logo.svg';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import axios from 'axios'
import TodoItemForm from './Component/TodoItemForm';
import TodoItemDisplay from './Component/TodoItemDisplay'
import { useState, useEffect } from 'react'

function App() {
  // deleteTodo={() => deleteTodo(todo.id)} 
  // switchTodoStatus={() => switchTodoStatus(todo.id)} todo={todo}
  const [todo,setTodo] = useState([])
  

  useEffect(() => {
    axios.get("http://localhost:7777/todo")
      .then((response) => {
        console.log(response);
        setTodo(response.data)
        
    }).catch(error => console.error(error))
},[] )
console.log(todo);
  return (
    <div className="App">
      <header className="App-header">        
        <TodoItemForm/>
        
        {todo.length>0 && todo.map((t ,index) => <TodoItemDisplay key={index} todo={t}/>)}
      </header>
    </div>
  );
}

export default App;
