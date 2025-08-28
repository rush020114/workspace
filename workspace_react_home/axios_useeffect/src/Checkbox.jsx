import React, { useState } from 'react'

const Checkbox = () => {

  // checkbox 데이터는 중복 선택 가능하므로 데이터를 배열에 저장한다.
  const [fruits, setFruits] = useState(['apple', 'orange', 'banana']);

  // 체크 박스 세팅 함수
  const handleFruits = e => {
    // 체크되면
    if(e.target.checked){
      // 다른 데이터는 그대로 두고 체크된 value를 추가하겠다.
      setFruits([
        ...fruits
        , e.target.value
      ])
    }
    // 체크 해제되면
    else{
      // filter함수 : 배열에 적용할 수 있는 함수로
      // 호출하면 배열을 return한다.
      // filter함수는 배열 각각의 데이터 중 조건에 부합하는 데이터만 리턴한다.
      // filter함수 문법 : 배열.filter((배열 각각의 지칭하는 변수) => {return(조건)}) 
      // fruits배열에서 하나하나씩 꺼낸 데이터 중
      // 해제된 데이터를 제외한 데이터들만 배열에 담아 리턴
      setFruits(
        // filter함수 조건 간략화
        fruits.filter(fruit => fruit !== e.target.value)
      )
    }
  }

  console.log(fruits)

  return (
    <div>
      {/* checkbox도 다른 form요소처럼 value값이 저장하고픈 데이터에 담긴다. */}
      <input
        type="checkbox" 
        value={'apple'}
        // checked는 true이면 check된다.
        // include함수는 배열에 적용할 수 있다.
        // 배열 안에 include함수의 매개변수가 들어있는지 판단하는 함수로
        // true, false를 리턴한다.
        checked={fruits.includes('apple')}
        onChange={e => handleFruits(e)}
      /> 사과
      <input
        type="checkbox" 
        value={'orange'}
        checked={fruits.includes('orange')}
        onChange={e => handleFruits(e)}
      /> 오렌지
      <input
        type="checkbox" 
        value={'banana'}
        checked={fruits.includes('banana')}
        onChange={e => handleFruits(e)}
      /> 바나나
    </div>
  )
}

export default Checkbox