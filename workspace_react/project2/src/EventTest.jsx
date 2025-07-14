import React from 'react'

const EventTest = () => {
  const btnName1 = '버튼1';
  const type1 = 'button';

  function f1(){
    alert('버튼 클릭');
  }
  return (
    <>
      {/* 변수는 중괄호에 감쌀 수 있는 모든 곳에서 사용 가능(태그의 속성값도 가능) */}
      {/* 화살표 함수가 이벤트에 통(내용부까지)으로 들어갈 수 있다. */}
      {/* 클릭했을 때 이 함수의 기능까지 실행시켜줄게 라는 뜻 */}
      <button type={type1} onClick={() => {alert(1);}}>{btnName1}</button> <br /> 
      <input type="text" onChange={() => {console.log(2);}}/> <br />

      <span onMouseEnter={() => alert(3)}>span 태그</span>
      <button type='button' onClick={() => f1()}>버튼2</button>
    </>
  )
}

export default EventTest;