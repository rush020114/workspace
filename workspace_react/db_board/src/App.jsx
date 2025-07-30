import { useEffect, useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import RegFrom from './RegFrom'
import BoardList from './BoardList'
import BoardDetail from './BoardDetail'
import { Route, Routes } from 'react-router-dom'
import axios from 'axios'

function App() {

  const [boardList, setBoardList] = useState([])

  const [selectedBoard, setSelectedBoard] = useState({})

  useEffect(() => {
    axios.get('/api/boards')
    .then(res => setBoardList(res.data))
    .catch(error => console.log(error))
  }, [])

  return (
    <>
      <Routes>
        <Route path='home' element={<BoardList boardList={boardList} setSelectedBoard={setSelectedBoard} />} />
        <Route path='/:boardNum' element={<BoardDetail selectedBoard={selectedBoard} />} />
        <Route path='reg' element={<RegFrom />} />
      </Routes>
    </>
  )
}

export default App
