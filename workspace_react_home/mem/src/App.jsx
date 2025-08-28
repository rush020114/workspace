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
import PersonalLayout from './layout/PersonalLayout'

function App() {


  return (
    <>
      <Routes>
        {/* 일반 사용자 layout */}
        <Route path='/' element={<UserLayout />}>
          {/* 옷 목록 */}
          <Route path='' element={<ClothingList />} />
          {/* 옷 상세 */}
          <Route path='clothing-detail/:clothingNum' element={<ClothingDetail />} />
        </Route>
        {/* 관리자 layout */}
        <Route path='/admin' element={<AdminLayout />}>
          {/* 옷 등록 */}
          <Route path='reg-clothing' element={<RegClothing />} />
        </Route>
        {/* 마이페이지 layout */}
        <Route path='/user' element={<PersonalLayout />}>
          {/* 옷 장바구니 */}
          <Route path='cart-list' element={<CartList />} />
        </Route>
      </Routes>
    </>
  )
}

export default App
