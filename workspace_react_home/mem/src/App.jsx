import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import { Route, Routes } from 'react-router-dom'
import UserLayout from './layout/UserLayout'
import AdminLayout from './layout/AdminLayout'
import RegClothing from './pages/RegClothing'
import ClothingList from './pages/ClothingList'
import ClothingDetail from './pages/ClothingDetail'
import CartList from './pages/CartList'

function App() {


  return (
    <>
      <Routes>
        <Route path='/' element={<UserLayout />}>
          <Route path='' element={<ClothingList />} />
          <Route path='clothing-detail/:clothingNum' element={<ClothingDetail />} />
          <Route path='cart-list' element={<CartList />} />
        </Route>
        <Route path='/admin' element={<AdminLayout />}>
          <Route path='reg-clothing' element={<RegClothing />} />
        </Route>
      </Routes>
    </>
  )
}

export default App
