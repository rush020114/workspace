import React, { useState } from 'react'
import styles from './UserHeader.module.css'
import Login from '../components/Login'
import Join from '../components/Join';

const UserHeader = () => {

  // login 컴포넌트로 모달을 열기 위해 사용할 state 변수
  const [isOpenLogin, setIsOpenLogin] = useState(false);
  
  // Join 컴포넌트로 모달을 열기 위해 사용할 state 변수
  const [isOpenJoin, setIsOpenJoin] = useState(false);

  return (
    <div className={styles.container}>
      <div className={styles.login_div}>
        {/* 로그인 텍스트를 누를 시 로그인 모달이 열리게 하는 함수 호출 */}
        <span onClick={e => setIsOpenLogin(true)}>LOGIN</span>
        {/* 회원가입 텍스트를 누를 시 로그인 모달이 열리게 하는 함수 호출 */}
        <span onClick={e => setIsOpenJoin(true)}>JOIN</span>
      </div>
      {/* 이미지 검색은 public을 기준으로 삼기 때문에 public 폴더 안에 있는 사진의 파일명을 현재폴더로 잡고 입력한다. */}
      <div className={styles.banner_div}>
        <img
         className={styles.banner_img}
         src="/book_banner.PNG" 
        />
        <p>BOOK SHOP</p>
      </div>
      <div className={styles.menu_div}>
        메뉴자리
      </div>
      {/* 각각의 모달 열고 닫히는 props 전달 */}
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