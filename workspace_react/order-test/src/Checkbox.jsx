import React, { useState } from 'react'

const Checkbox = () => {
  // 체크박스에서 선택한 데이터를 저장할 state변수
  // const [fruits, setFruits] = useState([]); 체크 박스 전체 해제
  
  // 마운트 시 체크하고 싶으면 초기값을 설졍해 주면 됨
  const [fruits, setFruits] = useState(['apple', 'orange', 'banana']);

  console.log(fruits)

  // 배열에서 특정 요소를 제거하는 코드 예시
  const arr = [1,2,3];
  // filter 함수는 배열 요소 중 특정 조건에 부합하는 데이터를 리턴
  // 문법 : 배열.filter((배열 각각의 데이터) => {return 조건})
  const result = arr.filter((num) => num > 1);

  // 배열에 특정 데이터가 포함되어 있는지 확인하는 문법
  const arr1 = ['가', '나', '다'];
  //arr1 배열에 '나'라는 문자가 있습니까?
  arr1.includes('나'); // 포함되어 있으면 true

  // 체크박스를 변경 시 실행되는 함수
  const handleCheckbox = e => {
    // 체크했으면...
    if(e.target.checked){
      setFruits([
        // 체크박스의 value를 추가한다.
        ...fruits
        , e.target.value
      ])
    }
    // 체크 해제했으면...
    else{
      setFruits(fruits.filter(fruit => fruit !== e.target.value))
    }
  }

  return (
    <div>
      <input 
        type="checkbox" 
        value={'apple'} 
        checked={fruits.includes('apple')}
        onChange={e => handleCheckbox(e)}
      /> 사과
      <input 
        type="checkbox" 
        value={'orange'} 
        checked={fruits.includes('orange')}
        onChange={e => handleCheckbox(e)}
      /> 오렌지
      <input 
        type="checkbox" 
        value={'banana'} 
        checked={fruits.includes('banana')}
        onChange={e => handleCheckbox(e)}
      /> 바나나
    </div>
  )
}

export default Checkbox