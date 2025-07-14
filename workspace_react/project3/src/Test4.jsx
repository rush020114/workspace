import React, { useState } from 'react'
import './Test4.css'

const Test4 = () => {
  const [arr, setArr] = useState([0, 0, 0]);
  
  // 숫자 클릭 시 실행되는 함수
  // 배열의 주소값이 바뀌지 않으면 useState가 바뀌었다고 해석하지 못한다.
  // 스프레드 연산자로 똑같은 데이터의 새로운 배열을 형성할 수 있다.
  function changeNum(index){
    const copyArr = [...arr]; 
    copyArr[index]++;
    setArr(copyArr);
  }
  
  return (
    <div className='test4_container'>
      <div onClick={() => changeNum(0)}>{arr[0]}</div>
      {/* 마찬가지로 현재 저장된 배열을 데이터는 두고 주소값만 바꾸어 복사한다. */}
      {/* 대신 그 값에서 배열 1번째 요소만 바꾼다. */}
      <div onClick={() => changeNum(1)}>{arr[1]}</div>
      <div onClick={() => changeNum(2)}>{arr[2]}</div>
    </div>
  )
}

export default Test4