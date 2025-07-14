import { useState } from "react";

const Test5 = () => {
  // 객체의 변화를 화면에 반영하기 위한 useState사용
  // useState매개변수에 초기값으로 들어간 객체를 man에 저장
  // setMan(state변경 함수)로 이벤트 시 화면에 변형된 객체를 반영 
  const [man, setMan] = useState({
    name: '김자바',
    age: 20,
    addr: '울산시'
})

  return(
    <div>
      {/* useState의 초기값으로 객체를 man에 저장했으므로 man을 객체처럼 사용가능 */}
      <h2>이름 : {man.name}</h2>
      <h2>나이 : {man.age}</h2>
      <h2>주소 : {man.addr}</h2>
      <button type="button" onClick={() => {
        // 스프레드 연산자로 새로운 객체를 생성하면서 
        // 객체 안의 키값이 같으면 마지막 키값을 덮어씌우는 성질을 이용해
        // 원하는 키값을 덮어씌움
        const newMan = {...man, name: '홍길동'}
        // 완전히 새로운 객체가 생성됐으므로 
        // useState문법 사용 시 필요한 조건인 새로운 주소값을 
        // 함수에 넣어야 state변경 함수가 바뀐 값을 화면에 반영을 충족
        // 따라서 원하는 키값만 변경된 새로운 배열을 넣었으므로 화면에 반영
        setMan(newMan)
      }}>홍길동</button>
      <button type="button" onClick={() => {
        const newMan = {...man, age: '30'}
        setMan(newMan)
      }}>30세</button>
      <button type="button" onClick={() => {
        const newMan = {...man, addr: '서울시'}
        setMan(newMan)
      }}>서울시</button>
    </div>
  )
}

export default Test5;