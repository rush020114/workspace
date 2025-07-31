import { useEffect, useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import RegFrom from './RegFrom'
import BoardList from './BoardList'
import BoardDetail from './BoardDetail'
import UpdateForm from './UpdateForm'
import { Route, Routes, useNavigate } from 'react-router-dom'
import axios from 'axios'

function App() {

  const nav = useNavigate()

  return (
    <div className='container'>
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
         element={<RegFrom 
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
    </div>
  )
}

export default App
