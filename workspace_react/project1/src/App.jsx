import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import Test from './Test'

const MyInput = () => <button type='button'>버튼1</button>

// jsx 문법에서의 태그는 반드시 닫는 태그가 있어야 함!
function App() {
  const myName = '홍길동';
  const myAge = 20;
  const arr = [1, 2, 3];
  // 객체를 jsx에 사용할 때는 객체전체를 사용할 수는 없다.
  const man = {
    name : 'lee',
    age : 30
  };
  // true, false와 null은 변수사용해도 화면에 나타나지 않는다.
  const bool = true;
  const data = null;
  const num = 7;
  return (
    <>
      <h3>{num % 2 === 0 ? '짝수' : '홀수'}</h3>
      <h3>{bool}</h3>
      <h3>{data}</h3>
      <h2>{arr[1]}</h2>
      <h2>{man.name}</h2>
      <h2>{myName}</h2>
      <h2>{myAge}</h2>
      <MyInput />
      <div>안녕하세요.</div>
      <Test />
      <input type="text" />
    </>
  )
}

export default App