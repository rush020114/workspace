import { useEffect } from "react";

// 컴포넌트 life cycle : mount, rerendering, unmount
// useEffect 문법 : 컴포넌트의 생애주기에 따라 특정 기능을 구현할 때 사용
const UseEffectTest = () => {
  console.log(0);

  // useEffect 안의 코드는 html 그림 다 그린 후 마지막에 실행!
  // useEffect의 두번째 매개변수를 사용하지 않으면 
  // mount, update시점에 실행
  useEffect(() => {
    console.log(1);
  });

  console.log(2);

  return(
    <div>useEffect</div>
  )
}

export default UseEffectTest;