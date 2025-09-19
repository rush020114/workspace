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
import BuyListForUser from './pages/BuyListForUser'
import BuyList from './pages/BuyList'
import UserQnA from './pages/UserQnA'
import AdminQnA from './pages/AdminQnA'
import UserInfo from './pages/UserInfo'
import UserQnADetail from './pages/UserQnADetail'
import AdminQnADetail from './pages/AdminQnADetail'

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
          {/* 구매 정보 조회 */}
          <Route path='buy-list' element={<BuyList />} />
          {/* 이용자 문의 목록 */}
          <Route path='qna' element={<AdminQnA />} />
          {/* 답변 */}
          <Route path='qna-detail/:qstId' element={<AdminQnADetail />} />
        </Route>
        {/* 마이페이지 layout */}
        <Route path='/user' element={<PersonalLayout />}>
          {/* 옷 장바구니 */}
          <Route path='cart-list' element={<CartList />} />
          {/* 사용자 구매 관리 */}
          <Route path='buy-list' element={<BuyListForUser />} />
          {/* 문의 */}
          <Route path='qna' element={<UserQnA />} />
          {/* 내정보 */}
          <Route path='info' element={<UserInfo />} />
          {/* 문의 상세 */}
          <Route path='qna-detail/:qstId' element={<UserQnADetail />} />
        </Route>
      </Routes>
    </>
  )
}

export default App
