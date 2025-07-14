import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import EventTest from './EventTest'

function App() {
  // 변화된 값을 화면에 보여주려면 변수 선언을 useState를 사용해서 선언한다.
  // useState()의 실행결과 : 배열로 반환한다.
  // useState() 실행결과 반환된 배열의 0번째 요소에는 초기값이 들어가 있고,
  // 1번째 요소에는 변수의 값을 변경시키는 기능의 함수가 함수가 들어가 있다.
  // useState의 배열의 0번째는 state변수이고 1번째는 state함수이다.
  // state변경 함수가 실행되면 state변수가 선언된 컴포넌트를 리렌더링(재실행)한다.
  let [title, setTitle] = useState('제목1');
  console.log(1);
  console.log(title);

  // 이벤트 : 뭔가 했을 때 발생하는 모든 것
  return (
    <>
      <h1>{title}</h1>
      <button type='button' onClick={() => setTitle('변경된 제목')}>제목 변경</button>
      {/* <EventTest /> */}
    </>
  )
}

export default App
