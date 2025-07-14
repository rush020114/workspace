import { useState } from 'react'
import './Test3.css'


const Test3 = () => {
  const [btn, setBtn] = useState('광고닫기');
  const [isShow, setIsShow] = useState(true);

  // jsx의 문법에서는 중괄호 안에 변수뿐만 아니고 자바스크립트 코드를 넣을 수 있다.
  // 삼항연산자는 가능하나  if문 for문은 못 쓴다.
  return (
    <div className='test3_container'>
      <button type='button' onClick={() => {
        setBtn(btn === '광고닫기' ? '광고보기' : '광고닫기')
        // 버튼 클릭시 true가 false, false가 true로 바뀌는 함수
        setIsShow(!isShow)
        }}>{btn}</button>
      {/* div태그를 보여주거나 null을 보여주는 문법 */}
      {/* 위의 이벤트로 isShow값이 변형되면 그 값에 따라 화면에 반영되는 코드가 달라짐 */}
      {isShow ? <div>오늘 구매하시면 30% SALE!!!</div> : null}
    </div>
  )
}

export default Test3