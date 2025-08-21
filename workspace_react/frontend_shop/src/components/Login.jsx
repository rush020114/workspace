import React, { useState } from 'react'
// ../는 상위 폴더로 찾아간다.
import Modal from '../common/Modal.jsx'
import Input from '../common/Input.jsx'
import Button from '../common/Button.jsx'
import styles from './Login.module.css'
import axios from 'axios'
import { useNavigate } from 'react-router-dom'

// component는 페이지에 붙이면 좋은 것들, 쉽게 말해 common도 아니고 page도 아닌 것이다.
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
        alert('로그인 가능');
        if(res.data.memRole === 'ADMIN'){
          nav('/admin/reg-book') 
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
        alert('로그인 불가능');   
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
          />
          <span><i className="bi bi-person-fill"></i></span>
        </div>
        <div className={styles.login_input}>
          <Input 
            name='memPw'
            value={loginData.memPw}
            onChange={e => handleLogin(e)}
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