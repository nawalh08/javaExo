import logo from './logo.svg';
import './App.css';
import FormComponent from './components/FormComponent/FormComponent';
import TableComponent from './components/TableComponent/TableComponent';
import { useState } from 'react';


function App() {
  const [liste,setList] = useState([])

  const addToList = (person) => {       
   setList([...liste,person]) 
  }

 
  return (
    <div className="App">
      <header className="App-header">
        <FormComponent addToList={addToList}/>
        <TableComponent liste = {liste}/>
        
      </header>
    </div>
  );
}


export default App;
