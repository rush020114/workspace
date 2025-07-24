import React, { useState } from 'react'

const Radio1 = () => {

  // 라디오에서 선택한 값을 저장할 state 변수
  // 라디오 값을 저장할 state 변수의 초기값은 최초로 선택할 태그의 value값으로 지정
  const [grade, setGrade] = useState('A')

  return (
    <div>
      <p>개발은 즐겁다.</p>
      <input
       type="radio" 
       name='grade'
       value={'A'}
       checked={grade === 'A'}
       onChange={e => setGrade(e.target.value)}
       /> 상
      <input
       type="radio"
       name='grade'
       value={'B'}
       checked={grade === 'B'}
       onChange={e => setGrade(e.target.value)}
       /> 중
      <input
       type="radio"
       name='grade'
       value={'C'}
       checked={grade === 'C'}
       onChange={e => setGrade(e.target.value)}
      /> 하
    </div>
  )
}

export default Radio1