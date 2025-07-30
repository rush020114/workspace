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

  const [selectedBoard, setSelectedBoard] = useState({})

  return (
    <>
      <Routes>
        <Route
         path=''
         element={<BoardList
          nav={nav}
          setSelectedBoard={setSelectedBoard}
         />} 
        />
        <Route 
         path='/:boardNum'
         element={<BoardDetail 
          nav={nav}
          selectedBoard={selectedBoard}
         />} 
        />
        <Route
         path='/reg' 
         element={<RegForm 
          nav={nav}
         />} 
        />
        <Route
         path='/update' 
         element={<UpdateForm 
         nav={nav}
         selectedBoard={selectedBoard}
         />} 
        />
      </Routes>
    </>
  )
}

export default App
