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
        alert('로그인 가능');
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
        alert('로그인 불가능')
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