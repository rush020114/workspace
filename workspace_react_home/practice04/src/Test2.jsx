import { useState } from "react"

const Test2 = () => {
  // 초기값으로 ON을 title에 저장하고 이벤트 발생으로 setTitle이 실행되면
  // useState가 선언된 컴포넌트를 리렌더링(다시 그림)하여 화면에 반영
  const [title, setTitle] = useState('ON');
  // 마찬가지로 초기값으로 OFF를 주고 이벤트로 변경된 값을 리렌더링 후 화면에 반영하겠다는 문장
  const [btn, setBtn] = useState('OFF');

  return (
    <div className="Test2_container">
      <h2>{title}</h2>
      <button type="button" onClick={() => {
        // state변경 함수(이벤트 시 화면에 값을 반영하게 해주는 함수) 내용부는 당연히 if문 for문 삼항연산자 등 javascript문이 들어올 수 있다.
        // setTitle 실행 시 이 삼항연산자로 나오는 값을 화면에 반영
        setTitle(title === 'ON' ? 'OFF' : 'ON')
        setBtn(btn === 'ON' ? 'OFF' : 'ON')
      }}>{btn}</button>
    </div>
  )
}

export default Test2