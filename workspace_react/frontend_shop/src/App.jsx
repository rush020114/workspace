import './App.css'
import UserLayout from './layout/UserLayout'
import { Route, Routes } from 'react-router-dom'
import BookList from './pages/BookList'
import AdminLayout from './layout/AdminLayout'
import RegBook from './pages/RegBook'
import CategoryManage from './pages/CategoryManage'
import BookDetail from './pages/BookDetail'
import CartList from './pages/CartList'
import PersonalLayout from './layout/PersonalLayout'
import BuyListForUser from './pages/BuyListForUser'
import BuyList from './pages/BuyList'
import BarChartTest from './components/BarChartTest'
import AdminHome from './pages/AdminHome'

function App() {

  return (
    <>
      <Routes>
        {/* 일반 사용자가 접근하는 페이지들 */}
        {/* 일반 사용자가 접근하는 페이지는 모두 UserLayout과 함께 열림 */}
        {/* UserLayout의 Outlet 위치에 우리가 원하는 컴포넌트가 뜬다. */}
        <Route path='/' element={<UserLayout />}>
          {/* 도서 목록 페이지, url : /list */}
          <Route path='' element={<BookList />} />
          {/* 도서 상세 페이지, url : /book-detail */}
          <Route path='book-detail/:bookNum' element={<BookDetail />} />
          {/* 바 차트 연습용 컴포넌트 */}
          <Route path='bar-chart' element={<BarChartTest />} />
        </Route>
        {/* 관리자 페이지는 AdminLayout이랑 함께 열린다. */}
        <Route path='/admin' element={<AdminLayout />}>
          {/* 도서 등록 페이지, url : /admin/reg */}
          <Route path='reg-book' element={<RegBook />} />
          {/* 카테고리 관리 페이지, url : /admin/cate-manage */}
          <Route path='cate-manage' element={<CategoryManage />} />
          {/* 구매이력조회 페이지, url : /admin/buy-list */}
          <Route path='buy-list' element={<BuyList />} />
          {/* 관리자 홈 */}
          <Route path='home' element={<AdminHome />} />
        </Route>
        {/* 마이페이지 layout */}
        <Route path='/user' element={<PersonalLayout />}>
          {/* 장바구니 목록 */}
          <Route path='cart-list' element={<CartList />} />
          {/* 구매 내역 */}
          <Route path='buy-list' element={<BuyListForUser />} />
        </Route>
      </Routes>
    </>
  )
}

export default App