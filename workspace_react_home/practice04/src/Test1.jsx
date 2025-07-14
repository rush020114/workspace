import { useState } from "react"
import './Test1.css' // 이 폴더의 '파일명'을 불러오겠습니다.

// Test1에 매개변수로 ..이 전달되어 어떤 내용을 실행하는 컴포넌트 정의
const Test1 = () => {
  // 값을 변형한 것을 화면에 나타내기 위해 사용하는 useState문법
  // 0을 초기값으로 설정해 cnt(state변수 : 초기값 저장)에 저장
  const [cnt, setCnt] = useState(0); 
  return(
    <div className="test1_container">
      {/* 변수 사용 */}
      <div>{cnt}</div>
      {/* 
        이벤트를 위해 useState문법으로 변수를 선언했고
        그 이벤트 구현을 onClick을 사용.
        속성 안에는 기능 구현을 위한 함수를 통으로 넣고
        함수 실행 부에 변형 실행을 해주는 것(함수 등)을 넣는다. 
      */}
      <button type="button" onClick={() => {setCnt(cnt + 1)}}>버튼</button>
    </div>
  )
}

export default Test1