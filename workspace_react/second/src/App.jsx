import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'

// react의 html코드는 App 컴포넌트 안의 return문에 작성한다.
// html코드는 무조건 하나의 최상위 태그를 지녀야 하며 그 태그를 빈태그로 줄 수 있다.(다른 태그는 디자인에 영향을 받으므로)

// 함수 vs 컴포넌트
// 이름이 소문자로 되어 있으면 함수!
// 이름이 대문자로 시작하면 컴포넌트!
// 컴포넌트는 만들어진 html을 호출한다.(코드의 중복사용을 해결하고 사용하고 싶은 곳에 마음대로 사용할 수 있다.)
function App() {
  const name = 'hi';
  const arr = [1,2,3];
  // 객체 자체는 html로 표현할 수 없다.
  const person = {
    name: 'kim', 
    age: 20
  };

  function Header(){
    return (
      <div>
        이곳은 header영역입니다.
      </div>
    )
  }

  return (
    <>
      <Header></Header>
      <div>{name}</div>
      <div>hello</div>
      <div>{arr}</div>
      <div>{arr[0]}</div>
      <div>{person.name}</div> 
      <div>
        이곳은 푸터 영역입니다.
      </div>
    </>
  )
}

export default App
