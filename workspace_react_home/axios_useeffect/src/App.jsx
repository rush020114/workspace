import { useEffect, useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import OrderInfo from './OrderInfo'
import BoardInfo from './BoardInfo'
import InputTest01 from './InputTest01'
import InputTest02 from './InputTest02'
import FormPractice01 from './FormPractice01'
import BookInfo from './BookInfo'
import axios from 'axios'

function App() {
  const [num, setNum] = useState(5);

  // 비동기 : 앞의 코드가 끝날 때까지 기다리지 않고 다음 코드를 실행한다.
  // 리렌더링은 state변경함수가 실행되자마자 하는 것이 아니라
  // 계속 진행하여 리렌더링할 것들을 모아서 대기시킨 후 한 번에 진행한다.
  // 그래서 첫번째 setNum이 진행되자마자 두번째 setNum이 진행되고
  // 두 개의 state변경함수는 state변수가 5인 상태로 진행되어 num이 10이 된다.
  useEffect(() => {
    setNum(num + 5);
    setNum(num + 5);
  }, [])

  // axios도 비동기이다.
  useEffect(() => {
    console.log(1)
    axios.get() 
    .then()
    .catch(console.log(3));
    console.log(2)
  })

  console.log(`num= ${num}`)

  return (
    <>
      {/* <OrderInfo /> */}
      {/* <BoardInfo /> */}
      {/* <InputTest01 /> */}
      {/* <InputTest02 /> */}
      {/* <FormPractice01 /> */}
      {/* <BookInfo /> */}
    </>
  )
}

export default App
