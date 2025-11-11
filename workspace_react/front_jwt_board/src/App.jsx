import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import { Route, Routes } from 'react-router-dom'
import BoardList from './pages/BoardList'
import Header from './components/Header'
import BoardDetail from './pages/BoardDetail'
import BoardWrite from './pages/BoardWrite'

function App() {

  return (
    <>
      <Header />
      <Routes>
        {/* 게시글 목록 페이지 */}
        <Route path='/' element={<BoardList />} />
        {/* 게시글 상세 페이지 */}
        <Route path='/board-detail/:boardNum' element={<BoardDetail />} />
        {/* 글 등록 페이지 */}
        <Route path='/write' element={<BoardWrite />} />
      </Routes>
    </>
  )
}

export default App
