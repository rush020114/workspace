import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import { Route, Routes } from 'react-router-dom'
import UserLayout from './layout/UserLayout'
import BookList from './pages/BookList'
import AdminLayout from './layout/AdminLayout'
import RegBook from './pages/RegBook'
import CategoryManage from './pages/CategoryManage'
import BookDetail from './pages/BookDetail'
import CartList from './pages/CartList'
import PersonalLayout from './layout/PersonalLayout'
import BuyList from './pages/BuyList'
import BuyListForUser from './pages/BuyListForUser'
import AdminHome from './pages/AdminHome'

function App() {

  return (
    <>
      {/* 페이지 이동을 위해선 Routes를 사용한다. */}
      <Routes>
        <Route path='/' element={<UserLayout />}>
          {/* 
           우리가 보는 창은 이 곳에 작성되는 route이기 때문에
           userLayout route 안에 작성한다.
           그러면 우리가 접근하고 싶은 화면이 나올 때 UserLayout이 함께
           실행되어 화면이 나온다.
          */}
          {/* 일반 사용자가 접근하는 페이지들 */}
          {/* 일반 사용자가 접근하는 페이지는 모두 UserLayout과 함께 열림 */}
          {/* UserLayout의 Outlet 위치에 우리가 원하는 컴포넌트가 뜬다. */}
          {/* 도서 목록 페이지, url : /list */}
          <Route path='' element={<BookList />} />
          <Route path='book-detail/:bookNum' element={<BookDetail />} />
        </Route>

        {/* 관리자페이지는 AdminLayout이랑 함께 열린다. */}
        <Route path='/admin' element={<AdminLayout />}>
          {/* 도서 등록 페이지, url : /admin/reg-book */}
          <Route path='reg-book' element={<RegBook />} />
          {/* 카테고리 관리 페이지, url : /admin/cate-manage */}
          <Route path='cate-mamnge' element={<CategoryManage />} />
          <Route path='buy-list' element={<BuyList />} />
          <Route path='home' element={<AdminHome />} />
        </Route>

        {/* 마이페이지 */}
        <Route path='/user' element={<PersonalLayout />}>
          <Route path='cart-list' element={<CartList />} />
          <Route path='buy-list' element={<BuyListForUser />} />
        </Route>
      </Routes>
    </>
  )
}

export default App
