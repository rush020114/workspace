import React from 'react'
import { useNavigate } from 'react-router-dom'

const Home = () => {
  // useNavigate() 훅을 사용하면 함수를 하나 리턴한다.
  const nav = useNavigate()

  return (
    <div>
      <h2>메인페이지</h2>
      <button
       type='button'
       onClick={e => {nav('/join')}}
      >회원가입 하러 가기</button>
      <div onClick={e => nav('/login')}>로그인하러 가기</div>
    </div>
  )
}

export default Home