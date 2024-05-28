import { useState } from 'react'
import './App.css'
import SignForm from './components/LogInComponent/SignForm'
import { useDispatch, useSelector } from 'react-redux'
// import TaskForm from './components/task/TaskForm'




  function App() {
    const user = useSelector(state => state.auth.user)
    const dispatch = useDispatch()
  return (
    <>
      {
        user ?
          // <TaskForm />
          <h1>Vous êtes connecté</h1>
        :
           <SignForm />
         
      }
    </>
  )
}

export default App
