import { useState } from "react";
import './test3.css'

const Test3 = () => {
  
  const [btn, setBtn] = useState("광고닫기");
  const [isShow, setIsShow] = useState(true);

  // 중괄호 안에는 자바스크립트 코드가 들어갈 수 있다.
  return (
    <div className="test3_container">
      <button type="button" onClick={() =>{
        setBtn(btn === '광고닫기' ? '광고보기' : '광고닫기');
        setIsShow(!isShow);
      }}>{btn}</button>

      {/* 중괄호 안에 if,for문은 들어가지 못하지만 삼항연산자능 가능하다. */}
      {isShow ? <div>오늘 구매하시면 30% SALE!!!</div> : null} 

      
    </div>
  )
}

export default Test3;