import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import { Route, Routes, useNavigate } from 'react-router-dom'
import Home from './Home'
import SignUp from './SignUp'
import Login from './Login'

function App() {

  const nav = useNavigate();

  return (
    <>
      <Routes>
        <Route
         path='/' 
         element={<Home 
          nav={nav}
         />} 
        />
        <Route
         path='/signup' 
         element={<SignUp 
          nav={nav}
         />} 
        />
        <Route
         path='/login' 
         element={<Login 
          nav={nav}
         />} 
        />
      </Routes>
    </>
  )
}

export default App
