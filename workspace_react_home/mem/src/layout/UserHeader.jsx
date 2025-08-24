import React, { useState } from 'react'
import styles from './UserHeader.module.css'
import Login from '../components/Login'
import SignUp from '../components/SignUp';
import { useNavigate } from 'react-router-dom';

const UserHeader = () => {

  const nav = useNavigate();

  // 로그인 여부 확인 state 변수
  const loginInfo = sessionStorage.getItem('loginInfo');

  // 로그인 데이터 객체화
  const loginData = JSON.parse(loginInfo);

  // 로그인 모달 여는 state 변수
  const [isOpenLogin, setIsOpenLogin] = useState(false);

  // 회원가입 모달 여는 state 변수
  const [isOpenSignUp, setIsOpenSignUp] = useState(false);

  return (
    <div className={styles.header}>
      <div className={styles.menu_div}>
        <h3>MEM</h3>
        <div>
          {
            !loginData
            ?
            <>
              <p onClick={e => setIsOpenLogin(true)}>LOGIN</p>
              <p onClick={e => setIsOpenSignUp(true)}>SIGN UP</p>
            </>
            :
            <>
              <p>{loginData.memId}님 환영합니다.</p>
              <p>마이페이지</p>
              <p 
                onClick={() => {
                  sessionStorage.removeItem('loginInfo')
                  nav('/')
                }}
              >LOGOUT</p>
            </>
          }
        </div>
      </div>
      <Login 
        isOpenLogin={isOpenLogin}
        onClose={() => setIsOpenLogin(false)}
      />
      <SignUp
        isOpenSignUp={isOpenSignUp}
        onClose={() => {setIsOpenSignUp(false)}}
      />
    </div>
  )
}

export default UserHeader