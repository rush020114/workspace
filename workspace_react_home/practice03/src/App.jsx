import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import Event from './Event'
function App() {
  // 이벤트 속성으로 값을 변경해도 이미 코드는 다 읽혔기 때문에 변경된 값이 화면에 반영이 안 된다.
  // 리액트는 그래서 useState문법을 제공한다.
  // useState : 변화된 값을 화면에 보여주기 위한 문법
  // 화면에 변화된 값을 반영하기 위해 useState를 사용해서 변수를 선언한다.
  // useState의 매개변수(초기값 설정)에 값을 넣으면 배열을 반환한다.
  // 반환된 0번째 배열(state변수)에는 초기값이 들어가 있고 1번째 배열에는 함수(state 변경 함수 : 변수의 값을 변경시키는 기능)가 들어가 있다.
  // 구조분해할당으로 useState값을 쉽게 저장할 수 있다.
  let [title, setTitle] = useState('제목1');

  return (
    <>
      {/* useState 사용으로 받은 초기값에 대한 변수 */}
      <h1>{title}</h1>
      {/* 
        이벤트 속성 함수 실행 내용에 useState함수(변수의 값을 변형시켜 화면에 반영하는 기능)를 호출해 이벤트를 구현할 수 있는 태그를 완성
        변경할 수 있는 이유 : state변수가 선언된 컴포넌트를 다시 실행시켜주기 때문(리렌더링) 
        리렌더링 시 useState가 선언된 문은 읽지 않는다. 
        그래서 state변수의 값은 초기화되지 않고 마지막 값을 저장한다.
      */}
      <button type='button' onClick={() => setTitle('변경된 제목')}>버튼</button>
      {/* <Event /> */}
    </>
  )
}

export default App
