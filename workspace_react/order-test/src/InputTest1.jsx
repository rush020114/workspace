import axios from "axios";
import { useState } from "react"

const InputTest1 = () => {
  // input 태그에 입력한 글자를 저장할 변수
  // input 태그에 입력한 데이터를 저장할 변수의 초기값은 빈 문자열로 선언(숫자도 문자로 인식) 
  const [itemNum, setItemNum] = useState('');
  console.log(itemNum)


  return(
    <div>
      <div>조회할 상품번호를 입력하세요</div>
      {/* 모든 이벤트 함수는 이벤트의 모든 정보를 가진 매개변수(객체)를 가진다. */}
      {/* 그 객체의 target키는 이벤트가 일어난 대상이다. */}
      {/* input 태그에 입력한 정보는 value 속성에 저장된다. */}
      {/* 입력할 때마다 value 값이 자동으로 수정된다. */}
      <input type="text" onChange={e => {
        console.log(e.target)
        console.log(e.target.value)
        setItemNum(e.target.value)
        }} /> <br />
      <button id="abc" className="ddd" type="button" onClick={e => {
        console.log(e.target)
        console.log(e.target.type) // button속성의 type값을 읽어오겠다.(target은 객체가 아니지만 .으로 접근가능)
        console.log(e.target.id)
        console.log(e.target.className)

        axios.get(`/api/orders/${itemNum}`)
        .then(res => console.log(res.data))
        .catch(error => console.log(error))
        }}>조회</button>
    </div>
  )
}

export default InputTest1