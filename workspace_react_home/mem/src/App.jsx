import { useCallback, useEffect, useState } from 'react'
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
import { useWebSocket } from './hooks/useWebSocket'
import { ToastContainer } from 'react-toastify'
// "이 CSS 파일을 프로젝트에 포함시켜" (그냥 추가)
import 'react-toastify/dist/ReactToastify.css'

function App() {

  // 수정 클릭 시 수정페이지로 바꿀 state 변수
  const [isOkayUpdate, setIsOkayUpdate] = useState(false);

  // ⭐ 로그인 정보를 state로 관리
  const [loginData, setLoginData] = useState(() => {
    const loginInfo = sessionStorage.getItem('loginInfo');
    return loginInfo ? JSON.parse(loginInfo) : null;
  });

  // 관리자 알림 개수 (새 문의)
  const [adminNotiCnt, setAdminNotiCnt] = useState(0);

  // 일반 사용자 알림 개수 (새 답변)
  const [userNotiCnt, setUserNotiCnt] = useState(0);

  // 로그인 처리 함수
  const handleLogin = () => {
    const loginInfo = sessionStorage.getItem('loginInfo');
    if(loginInfo){
      setLoginData(JSON.parse(loginInfo));
    }
  }

  // 로그아웃 처리 함수
  const handleLogout = () => {
    setLoginData(null);
    // 로그 아웃 시 개수 초기화
    setAdminNotiCnt(0);
    setUserNotiCnt(0);
  };

  // WebSocket에서 알림 받을 때 실행되는 함수
  // socket 구독 시 함수 참조값 유지를 위해 useCallback을 쓴다(참조값 바뀌면 인식 불가능).
  const handleNoti = useCallback(isAdmin => {
    console.log('🔔 handleNoti 실행!', isAdmin);  // ⭐ 추가
    if(isAdmin){
      console.log('관리자 카운트 증가');  // ⭐ 추가
      // 관리자면 카운트 증가
      // setState는 비동기지만,
      // prev를 사용하면 항상 최신 state를 기준으로
      // 업데이트가 순차적으로 처리되어 값 누락이 없다.
      // 결론 : 빠르게 눌러도 1씩 증가
      setAdminNotiCnt(prev => prev + 1);
    }
    else{
      setUserNotiCnt(prev => prev + 1);
    };
  }, []);
  
  // 배지 클릭 시 알림 개수 초기화
  const resetAdminCnt = () => {
    setAdminNotiCnt(0);
  };

  const resetUserCnt = () => {
    setUserNotiCnt(0);
  };


  // WebSocket 연결
  const isAdmin = loginData?.memRole === 'ADMIN';
  useWebSocket(loginData?.memId, isAdmin, handleNoti);

  return (
    <>
      <Routes>
        {/* 일반 사용자 layout */}
        <Route path='/' element={<UserLayout 
          onLogin={handleLogin}
          onLogout={handleLogout}
          notiCnt={userNotiCnt}  // ⭐ 알림 개수 전달
        />}>
          {/* 옷 목록 */}
          <Route path='' element={<ClothingList />} />
          {/* 옷 상세 */}
          <Route path='clothing-detail/:clothingNum' element={<ClothingDetail />} />
        </Route>
        {/* 관리자 layout */}
        <Route path='/admin' element={<AdminLayout 
          notiCnt={adminNotiCnt} // 알림 개수
          onResetCnt={resetAdminCnt} // 알림 개수 초기화 함수
        />}>
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
        <Route path='/user' element={<PersonalLayout 
          notiCnt={userNotiCnt}
          onResetCnt={resetUserCnt}
        />}>
          {/* 옷 장바구니 */}
          <Route path='cart-list' element={<CartList />} />
          {/* 사용자 구매 관리 */}
          <Route path='buy-list' element={<BuyListForUser />} />
          {/* 문의 */}
          <Route path='qna' element={<UserQnA />} />
          {/* 내정보 */}
          <Route path='info' element={<UserInfo 
            setIsOkayUpdate={() => setIsOkayUpdate(true)}
          />} />
          {/* 문의 상세 */}
          <Route path='qna-detail/:qstId' element={<UserQnADetail 
            isOkayUpdate={isOkayUpdate}
          />} />
        </Route>
      </Routes>

      {/* ⭐ Toast 컨테이너: 알림 팝업이 여기에 뜸 */}
      <ToastContainer 
        position="top-right"          // 위치: 우측 상단
        autoClose={3000}              // 3초 후 자동 닫힘
        hideProgressBar={true}       // 진행바 표시
        newestOnTop={true}            // 새 알림이 위로
        closeOnClick                  // 클릭하면 닫힘
        pauseOnHover                  // 마우스 올리면 멈춤
        draggable                     // 드래그 가능
        theme="light"                 // 테마: light/dark/colored
      />
    </>
  )
}

export default App