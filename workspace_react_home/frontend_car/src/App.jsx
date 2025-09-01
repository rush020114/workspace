import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import { Route, Routes } from 'react-router-dom'
import CarLayout from './layout/CarLayout'
import Home from './pages/Home'

function App() {

  return (
    <>
      <Routes>
        <Route path='/' element={<CarLayout />}>
          <Route path='' element={<Home />} />
        </Route>
      </Routes>
    </>
  )
}

export default App
