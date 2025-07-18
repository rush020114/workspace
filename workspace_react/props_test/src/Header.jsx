import React from 'react'

// 부모 컨포넌트에서 전달되는 데이터는 자식 컴포넌트의 매개변수 위치에 props라는 키워드로 받을 수 있다.
// props는 전달되는 데이터를 객체 형태로 받는다.
const Header = (props) => {
  console.log(props); // 데이터 형태가 궁금하면 항상 출력!
  return (
    <div>전달받은 나이 : {props.age}</div>
  )
}

export default Header