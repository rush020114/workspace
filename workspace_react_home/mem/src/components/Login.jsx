import React, { useState } from 'react'
import Modal from '../common/Modal'
import Input from '../common/Input'
import Button from '../common/Button'
import styles from './Login.module.css'
import axios from 'axios'
import { useNavigate } from 'react-router-dom'

const Login = ({isOpenLogin, onClose}) => {

  const nav = useNavigate();

  // 로그인 값 저장 state 변수
  const[loginData, setLoginData] = useState({
    memId: ''
    , memPw: ''
  });

  // 로그인 값 세팅 함수
  const handleLoginData = e => {
    setLoginData({
      ...loginData
      , [e.target.name]: e.target.value
    });
  };

  // 로그인 함수
  const login = () => {
    axios.get(`/api/members`, {params: loginData})
    .then(res => {
      if(res.data){
        alert('환영합니다.');
        sessionStorage.setItem('loginInfo', JSON.stringify({
          memId: res.data.memId
          , memName: res.data.memName
          , memRole: res.data.memRole
        }));
        if(res.data.memRole === 'ADMIN'){
          nav('/admin/reg-clothing');
        }
        else{
          setLoginData({
            memId: ''
            , memPw: ''
          });
          onClose();
          nav('/');
        };
      }
      else{
        alert('아이디 도는 비밀번호가 일치하지 않습니다.');
        setLoginData({
          memId: ''
          , memPw: ''
        });
      };
    })
    .catch(e => console.log(e));
  }

  return (
    <Modal
       title='Login'
       size='350px'
       isOpen={isOpenLogin}
       onClose={() => {
        onClose();
        setLoginData({
          memId: ''
          , memPw: ''
        });
      }}
      >
        <div className={styles.container}>
          <div className={styles.input}>
            <div>
              <p>아이디</p>
              <Input 
                size='100%'
                padding='12px'
                placeholder='아이디를 입력하세요.'
                name='memId'
                value={loginData.memId}
                onChange={e => handleLoginData(e)}
              />
            </div>
            <div>
              <p>비밀번호</p>
              <Input 
                type='password'
                padding='12px'
                size='100%'
                placeholder='비밀번호를 입력하세요.'
                name='memPw'
                value={loginData.memPw}
                onChange={e => handleLoginData(e)}
              />
            </div>
          </div>
          <div>
            <Button 
              size='100%'
              padding='10px'
              content='로 그 인'
              onClick={() => login()}
            />
          </div>
        </div>
      </Modal>
  )
}

export default Login