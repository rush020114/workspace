import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import { Route, Routes } from 'react-router-dom'
import CarLayout from './layout/CarLayout'
import Home from './pages/Home'
import ManageCar from './pages/ManageCar'
import RegSalesInfo from './pages/RegSalesInfo'
import SalesInfoList from './pages/SalesInfoList'

function App() {

  return (
    <>
      <Routes>
        {/* 차량 레이아웃  */}
        <Route path='/' element={<CarLayout />}>
          {/* 차량 홈 */}
          <Route path='' element={<Home />} />
          {/* 차량 관리페이지 */}
          <Route path='manage-car' element={<ManageCar />} />
          {/* 판매정보등록 페이지 */}
          <Route path='reg-sales' element={<RegSalesInfo />} />
          {/* 판매목록조회 페이지 */}
          <Route path='sales-info' element={<SalesInfoList />} />
        </Route>
      </Routes>
    </>
  )
}

export default App
