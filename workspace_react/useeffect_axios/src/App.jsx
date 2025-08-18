import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import UseEffectTest from './UseEffectTest'
import UseEffectTest2 from './UseEffectTest2'
import UseEffectTest3 from './UseEffectTest3'
import Axios_1 from './Axios_1'
import Axios_2 from './Axios_2'
import Axios_3 from './Axios_3'
import Axios_4 from './Axios_4'
import Axios_5 from './Axios_5'
import axios from 'axios'

function App() {

    const [num, setNum] = useState(5);

  // 비동기 : 앞의 코드가 끝날 때까지 기다리지 않는다.
  // 리렌더링할 것이 두 개 이상되면 그림을 다 그리고 리렌더링한다.
  // 코드가 실행되자마자 다음 코드를 실행하기에
  // 두 state변수는 전부 값이 5에서 5를 더하게 된다. 
  useEffect(() => {
    setNum(num + 5);
    setNum(num + 5);
  }, []);

  // axios도 비동기이다.
  useEffect(() => {
    console.log(1)
    axios.get() 
    .then()
    .catch(console.log(3));
    console.log(2)
  })

  console.log(`num = ${num}`)

  return (
    <>
      {/* <UseEffectTest /> */}
      {/* <UseEffectTest2 /> */}
      {/* <UseEffectTest3 /> */}
      {/* <Axios_1 /> */}
      {/* <Axios_2 /> */}
      {/* <Axios_3 /> */}
      {/* <Axios_4 /> */}
      <Axios_5 />
    </>
  )
}

export default App