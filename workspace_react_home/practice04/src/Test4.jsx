import { useState } from "react"
import './Test4.css'

const Test4 = () => {
  // 배열 구조분해할당과 useState문법 활용
  const [arr, setArr] = useState([0, 0, 0])

  const changeNum = index => {
    // 스프레드 연산자로 arr의 배열의 껍질을 벗기고 새로운 배열로 감싸며 주소값 변경
    const newArr = [...arr]
    // index번째 요소만 변형하고 나머지 요소는 그대로 두는 연산
    newArr[index]++;
    // 배열의 주소값이 변형됐으므로 setArr(State변형 함수)가 state변수가 변형됨을 인지하고 변화된 값을 화면에 반영
    setArr(newArr)
  }

  return (
    <div className="test4_container">
      {/* 구조분해할당된 배열을 활용한 변수 사용 */}
      {/* 
        state변경 함수는 state변수(주소값)가 변경되어야
        그 값을 화면에 반영시킨다.
        배열은 각 요소값이 바뀌는 것이 주소값이 변했다는 것을 의미하지 않는다.
        그러므로 새로운 배열을 만들어주어야 하는데
        그 방법이 스프레드 연산자를 이용하여 새로운 배열을 저장하는 것이다.
        만약 배열의 데이터를 변형시키지 않고 주소값만 바꾸고 싶다면 이 방법을 이용하면 된다.
      */}
      {/* 함수를 정의해 중복되는 코드를 한 줄로 줄이고 중괄호까지 생략할 수 있게 되었음 */}
      <div onClick={() => changeNum(0)}>{arr[0]}</div>
      <div onClick={() => changeNum(1)}>{arr[1]}</div>
      <div onClick={() => changeNum(2)}>{arr[2]}</div>
    </div>   
  )
}

export default Test4