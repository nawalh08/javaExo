import logo from './logo.svg';
import './App.css';
import LoginFormComponent from './Component/LoginFormComponent/LoginFormComponent';

function App() {

  function Recup (user,password){
    console.log("Username = " + user + " & Password = " + password);
  }
  return (
    <div className="App">
      <header className="App-header">
        <LoginFormComponent Recup={Recup}/>
      </header>
    </div>
  );
}

export default App;
