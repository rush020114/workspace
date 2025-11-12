import React, { useState } from 'react'
import { joinApi } from '../apis/member/member_api';
import { useNavigate } from 'react-router-dom';

const Join = () => {
  const nav = useNavigate();
  
  // 회원가입 데이터
  const [joinData, setJoinData] = useState({
    memEmail: ''
    , memPw: ''
    , memName: ''
  });

  // 회원가입 데이터를 세팅할 함수
  const handleJoinData = e => {
    setJoinData({
      ...joinData
      , [e.target.name]: e.target.value
    });
  };

  // 회원 가입
  const join = async data => {
    await joinApi(data);
    nav('/');
  }
  
  console.log(joinData)

  return (
    <div>
      <div>이메일</div> 
      <input 
        type="text" 
        name='memEmail'
        value={joinData.memEmail}
        onChange={e => handleJoinData(e)}
      /> <br />
      <div>비밀번호</div> 
      <input 
        type="password" 
        name='memPw'
        value={joinData.memPw}
        onChange={e => handleJoinData(e)}
      /> <br />
      <div>이름</div> 
      <input 
        type="text" 
        name='memName'
        value={joinData.memName}
        onChange={e => handleJoinData(e)}
      /> <br />
      <button
        type='button'
        onClick={() => join(joinData)}
      >
        회원가입
      </button>
    </div>
  )
}

export default Join