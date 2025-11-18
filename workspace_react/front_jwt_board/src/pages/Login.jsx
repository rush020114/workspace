import React, { useState } from 'react'
import { loginApi } from '../apis/member/member_api';

const Login = () => {
  // 로그인을 위한 정보를 저장할 state 변수
  const [loginData, setLoginData] = useState({
    memEmail: ''
    , memPw: ''
  });

  const handleLoginData = e => {
    setLoginData({
      ...loginData
      , [e.target.name]: e.target.value
    });
  };

  const loginProccess = async data => {
    await loginApi(data)
  }
  
  return (
    <div>
      아이디 : 
      <input 
        type="text" 
        name='memEmail'
        value={loginData.memEmail}
        onChange={e => handleLoginData(e)}
      /> <br />
      비번 : 
      <input 
        type="text" 
        name='memPw'
        value={loginData.memPw}
        onChange={e => handleLoginData(e)}
      /> <br />
      <button 
        type='button'
        onClick={() => loginProccess(loginData)}
      >로그인</button>
    </div>
  )
}

export default Login