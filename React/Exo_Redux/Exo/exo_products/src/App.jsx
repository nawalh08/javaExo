import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import ProductForm from './Components/ProductForm'
import ProductList from './Components/ProductDisplay'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
     <ProductForm/>
     <ProductList/>
    </>
  )
}

export default App
