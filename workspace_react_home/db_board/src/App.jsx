import { useEffect, useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import { Route, Routes, useNavigate } from 'react-router-dom'
import BoardList from './BoardList'
import BoardDetail from './BoardDetail'
import RegForm from './RegForm'
import axios from 'axios'
import UpdateForm from './UpdateForm'

function App() {

  const nav = useNavigate()

  return (
    <>
      <Routes>
        <Route
         path='/'
         element={<BoardList
          nav={nav}
         />} 
        />
        <Route 
         path='/:boardNum'
         element={<BoardDetail 
          nav={nav}
         />} 
        />
        <Route
         path='/reg' 
         element={<RegForm 
          nav={nav}
         />} 
        />
        <Route
         path='/:boardNum/update' 
         element={<UpdateForm 
         nav={nav}
         />} 
        />
      </Routes>
    </>
  )
}

export default App
