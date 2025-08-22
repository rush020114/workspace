import React, { useState } from 'react'
// ../는 상위 폴더로 찾아간다.
import Modal from '../common/Modal.jsx'
import Input from '../common/Input.jsx'
import Button from '../common/Button.jsx'
import styles from './Login.module.css'
import axios from 'axios'
import { useNavigate } from 'react-router-dom'

// component는 페이지에 붙이면 좋은 것들, 쉽게 말해 common도 아니고 page도 아닌 것이다.
// 로그인한 정보는 컴포넌트가 마운트 혹은 새로고침되어도 사리지지 않아야 한다.
// 그래서 로그인 정보는 일반 변수나 state변수에 저장하면 안된다.
// 클라이언트(웹 브라우저)는 자체적으로 데이터를 저장할 공간을 3개 제공한다.
// 이 세 곳에 데이터를 저장하면 페이지가 새로고침되어도 데이터가 사라지지 않는다.
// 3개의 공간 : Cookie, sessonStorage, localStorage
// Cookie : 문자열 데이터만 저장 가능
//          저장가능 크기 : 4kb 
//          spring과 통신 시 자동으로 데이터가 전달됨
//          저장 기간을 설정할 수 있음
// sessionStorage, localStorage : 문자열 데이터만 저장 가능
//                              : 저장가능 크기 : 10mb
//                              : spring과 통신 시 명시적으로 전달해야 한다.
// sessionStorage vs localStorage
// localStorage : 저장된 데이터가 영구적. 직접 지우지 않으면 사라지지 않는다.
//                웹 브라우저 탭 간에 데이터를 공유하지 않는다.
// sessionStorage : 저장된 데이터가 웹 브라우저가 종료되면 자동으로 사라진다.
//                  웹 브라우저 탭 간에 데이터를 공유한다.

// sessionStorage, localStorage에 데이터를 저장하고 읽는 문법
// 저장 문법
// sessionStorage.setItem('이름', 데이터), localStorage.setItem('이름', 데이터)
// ex) sessionStorage.setItem('age', '20')
// 조회 문법
// sessionStorage.getItem('저장된 데이터 이름'), localStorage.getItem('저장된 데이터 이름')
// ex) sessionStorage.getItem('age')
// sessionStorage에 저장된 데이터 삭제 문법
// sessionStorage.removeItem('저장된 데이터 이름')

const Login = ({isOpenLogin, onClose}) => {

  const nav = useNavigate();

  // 로그인 값을 저장할 state 변수
  const [loginData, setLoginData] = useState({
    memId: ''
    , memPw: ''
  });

  // 로그인 값 세팅
  const handleLogin = e => {
    setLoginData({
      ...loginData
      , [e.target.name]: e.target.value
    });
  };

  // 로그인하는 함수
  const login = () => {
    // params 키는 정해져 있다.(가져갈 데이터라는 의미)
    axios.get(`/api/members/login`, {params : loginData})
    .then(res => {
      if(res.data){
        alert('환영합니다.');
        
        // 로그인한 id, 이름, 권한 정보만을 갖는 객체를 생성
        const loginInfo = {
          memId: res.data.memId
          , memName: res.data.memName
          , memRole: res.data.memRole
        }

        console.log(loginInfo)
        console.log(JSON.stringify(loginInfo))

        // 로그인한 유저의 ID, 이름, 권한을 sessionStorage에 저장
        // sessionStorage에는 문자열 데이터만 저장 가능하기 때문에
        // 객체 타입의 res.data를 직접 저장할 수는 없다.
        // 그래서 객체를 문자열로 바꾸어 저장
        // res.data -> {memId: 'user', memName: '일반유저', memRole: 'USER'}
        // 문자열로 바꾸면 -> '{memId: 'user', memName: '일반유저', memRole: 'USER'}'

        // 객체를 문자열로 바꾼 자료형 : JSON
        // 객체를 문자열로 바꾸기 : JSON.stringify(객체)
        // JSON을 객체로 변경하는 문법 : JSON.parse(JSON데이터)
        sessionStorage.setItem('loginInfo', JSON.stringify(loginInfo));

        if(res.data.memRole === 'ADMIN'){
          nav('/admin/reg-book');
        } 
        else{
          onClose();
          setLoginData({
            memId: ''
            , memPw: ''
          });
          nav('/');
        };
      }
      else{
        alert('ID 또는 비밀번호가 일치하지 않습니다.');   
        setLoginData({
          memId: ''
          , memPw: ''
        });     
      };
    })
    .catch(e => console.log(e));
  };

  return (
    <Modal
     isOpen={isOpenLogin}
     title='login'
     size='300px'
     onClose={() => {
      onClose()
      setLoginData({
        memId: ''
        , memPw: ''
      })
    }}
    >
      <div className={styles.login_div}>
        <div className={styles.login_input}>
          <Input 
            name='memId'
            value={loginData.memId}
            onChange={e => handleLogin(e)}
            size='100%'
            placeholder='Input your ID'
            padding='3px 5px 3px 25px'
            onKeyDown={e => {if(e.key === 'Enter') login()}}
          />
          <span><i className="bi bi-person-fill"></i></span>
        </div>
        <div className={styles.login_input}>
          <Input 
            name='memPw'
            value={loginData.memPw}
            onChange={e => handleLogin(e)}
            onKeyDown={e => {if(e.key === 'Enter') login()}}
            size='100%'
            placeholder='Input your Password'
            type='password'
            padding='3px 5px 3px 25px'
          />
          <span><i className="bi bi-lock-fill"></i></span>
        </div>
        <Button
          onClick={e => login()}
          size='100%'
          title='Sign in'
          color='green'
        />
      </div>
    </Modal>
  )
}

export default Login