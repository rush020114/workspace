import React, { useState } from 'react'
import Modal from '../common/Modal'
import Input from '../common/Input'
import Button from '../common/Button'
import styles from './Login.module.css'
import axios from 'axios'
import { useNavigate } from 'react-router-dom'

const Login = ({isOpenLogin, onClose}) => {

  const nav = useNavigate();

  // 로그인 데이터 세팅 state변수
  const [loginData, setLoginData] = useState({
    memId: ''
    , memPw : ''
  });

  // 로그인 값 변경 함수
  const handleLoginData = e => {
    setLoginData({
      ...loginData
      , [e.target.name]: e.target.value
    });
  };

  // 로그인 함수
  const login = () => {
    // 두 개 이상의 데이터를 스프링으로 넘기기 위한 두번째 매개변수
    // 객체 안에 객체 형식으로 스프링으로 두 개 이상의 값을 넘길 수 있다.
    axios.get('/api/members/login', {params: loginData})
    .then(res => {
      if(res.data){
        alert('환영합니다.');
        // sessionStorage는 새로고침되어도 로그인 정보가 남을 수 있게 해주는 웹 브라우저가 제공하는 저장 공간이다. 
        // 다른 두 저장공간과 웹브라우저가 종료될 때 데이터가 사라진다. 그리고 탭 간 데이터를 공유한다.
        // 저장 문법은 setItem함수를 쓰며 매개변수로 키이름, 저장할 값(문자, 객체 등)를 받는다.
        // 이때 매개변수는 전부 문자열이어야 한다. 그래서 객체를 전달할 때는 JSON문법을 쓴다.
        // JSON언어는 공용 프로그래밍 언어로 다른 언어끼리 데이터를 교환할 수 있게 해준다.
        // JSON으로 객체를 문자열화하고 문자열화한 객체를 일반 객체로 풀 수 있다.
        // 저장 공간에 저장된 데이터는 key: value(문자열)형식으로 저장된다.
        // 저장된 데이터를 읽을 땐 getItem함수를 호출하며 매개변수로 저장된 키값을 문자열로 적는다.
        // 로그인했을 때 
        sessionStorage.setItem('loginInfo', JSON.stringify({
          memId: res.data.memId
          , memName: res.data.memName
          , memRole: res.data.memRole
        }))
        if(res.data.memRole === 'ADMIN'){
          nav('/admin/reg-book');
        }
        else{
          setLoginData({
            memId: ''
            , memPw : ''
          });
          onClose();
          nav('/');
        };
      }
      else{
        alert('아이디 또는 비밀번호가 일치하지 않습니다.')
        setLoginData({
          memId: ''
          , memPw : ''
        })
      };
    })
    .catch(e => console.log(e));
  };

  return (
    <Modal
     isOpen={isOpenLogin}
     title={'login'}
     size={'300px'}
     onClose={() => {
      onClose()
      setLoginData({
        memId: ''
       , memPw : ''
      })
     }}
    >
      <div className={styles.container}>
        <div className={styles.login_input}>
          <Input 
            size='100%'
            type='text'
            padding='5px 5px 5px 25px'
            placeholder={'Username'}
            name='memId'
            value={loginData.memId}
            onChange={e => handleLoginData(e)}
            onKeyDown={e => {if(e.key === 'Enter') login()}}
          />
          <span><i className="bi bi-person-fill"></i></span>
        </div>
        <div className={styles.login_input}>
          <Input 
            size='100%'
            type='password'
            padding='5px 5px 5px 25px'
            placeholder={'Password'}
            name='memPw'
            value={loginData.memPw}
            onChange={e => handleLoginData(e)}
            onKeyDown={e => {if(e.key === 'Enter') login()}}
          />
          <span><i className="bi bi-lock-fill"></i></span>
        </div>
        <div className={styles.login_btn}>
          <Button 
            size='100%'
            title='로그인'
            color='green'
            onClick={() => login()}
          />
        </div>
      </div>
    </Modal>
  )
}

export default Login