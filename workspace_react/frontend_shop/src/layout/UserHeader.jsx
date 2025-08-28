import { useState } from 'react'
import styles from './UserHeader.module.css'
import Login from '../components/Login'
import Join from '../components/Join';
import { useNavigate } from 'react-router-dom';

const UserHeader = () => {
  
  const nav = useNavigate();

  // sessionStorage에 저장한 loginInfo를 가져온다.
  // 데이터가 없다면 null이 뜬다.
  const loginInfo = sessionStorage.getItem('loginInfo')

  const loginData = JSON.parse(loginInfo);

  // 로그인 모달창 숨김/보이기 여부
  const [isOpenLogin, setIsOpenLogin] = useState(false);

  // 회원가입 모달창 숨김/보이기 여부
  const [isOpenJoin, setIsOpenJoin] = useState(false);

  return (
    <div className={styles.container}>
      <div className={styles.login_div}>
        {
          !loginInfo 
          ?
          <>
            <span onClick={e => setIsOpenLogin(true)}>LOGIN</span>
            <span onClick={e => setIsOpenJoin(true)}>JOIN</span>
          </>
          :
          <>
            {/* loginInfo는 json이기 때문에 객체로 변경해서 사용해야 한다. */}
            <span>{loginData.memId}님 환영합니다!</span>
            <span
              onClick={() => nav('/user/cart-list')}
            >마이페이지</span>
            <span onClick={() => {
                sessionStorage.removeItem('loginInfo');
                nav('/');
              }}>LOGOUT</span>
          </>
        }
      </div>
      <div className={styles.banner_div}
        onClick={() => nav('/')}
      >
        <img
         className={styles.banner_img}
         src="/book_banner.PNG" 
        />
        <p>BOOK SHOP</p>
      </div>
      <div className={styles.menu_div}>
        메뉴 영역
      </div>

      {/* 로그인 모달 컴포넌트 */}
      <Login
       isOpenLogin={isOpenLogin} 
       onClose={() => setIsOpenLogin(false)}
      />
      <Join 
       isOpenJoin={isOpenJoin}
       onClose={() => setIsOpenJoin(false)}
      />
    </div>
  )
}

export default UserHeader