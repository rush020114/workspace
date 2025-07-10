import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'

// react의 가장 큰 특징은 html을 컴포넌트로 구성한다.
// 컴포넌트는 중복되는 html코드를 따로 구성함으로써 그 영역의 수정과 사용을 쉽게 만든다.
// 컴포넌트는 자바스크립트 함수와 비슷한 생김새로 return에 소괄호가 추가되고 컴포넌트명의 앞글자가 대문자이다.
// 컴포넌트 실행 방법은 태그를 부르듯이 사용하면 된다.(컴포넌트명 대소문자를 구분해 똑같이 입력)

function Header(){
  return(
    <div>헤더 영역입니다.</div>
  )
}

function App() {

  return (
    <>
    {/* 컴포넌트를 구성함으로써 마음대로 중복되는 코드를 쉽게 사용할 수 있게 되었다. */}
      <Header></Header>  
      <Header></Header>
      <div>hello</div>
    </>
   
  )
}

export default App
