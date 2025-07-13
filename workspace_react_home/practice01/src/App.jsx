import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import Header from './Header'

// jsx에서 js문은 컴포넌트 안 return문 바깥에 사용한다.
// jsx에서는 html에 변수를 사용할 수 있게 해준다.
function App() {
  const myName = '홍길동';
  const myAge = 20;
  const man = { // return문 안에서 객체는 객체 자체를 사용할 수 없으므로 객체의 key값으로 접근해야 한다.
    name : 'lee',
    age : 30
  };

  const bool = true; // 불린 값과 null은 화면에 표시가 되지 않는다.
  const data = null;
  // 자바스크립트 문법을 html에 적용시 숫자나 문자 등 하나의 값으로만 평가되는 문법만 쓸 수 있다. 
  const num = 7; // 이 변수를 return문 안에서 삼항연산자로 활용할 수 있다.(if문은 되지 않음.)
  return (
    <>
      <Header /> {/* 태그 안에 아무것도 쓰지 않을 거면 이런 식으로 바로 닫을 수 있다. 이런 태그는 컴포넌트뿐 아니라 html코드도 적용된다.(jsx는 html을 약간 변형해서 사용하기 때문이다.) */}
      <h3>{num % 2 ? '짝수' : '홀수'}</h3>
      <h2>{myName}</h2> {/* 변수 사용 문법 */}
      <h2>{myAge}</h2>
      <h2>{man.age}</h2>
    </>
  )
}

export default App
