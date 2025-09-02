import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import { Route, Routes } from 'react-router-dom'
import CarLayout from './layout/CarLayout'
import Home from './pages/Home'
import ManageCar from './pages/ManageCar'
import SalesInfoList from './pages/SalesInfoList'
import RegSalesInfo from './pages/RegSalesInfo'

function App() {

  return (
    <>
      <Routes>
        <Route path='/' element={<CarLayout />}>
          <Route path='' element={<Home />} />
          <Route path='manage-car' element={<ManageCar />} />
          <Route path='reg-sales' element={<RegSalesInfo />} />
          <Route path='sales-info' element={<SalesInfoList />} />
        </Route>
      </Routes>
    </>
  )
}

export default App
