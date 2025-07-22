import { useState } from "react"

const InputTest4 = () => {

  const man = {
    name: 'kim',
    age: 20
  }

  const v = 'age' // .으로 v에 접근할 시 이 변수는 무시됨.
  // man.v 이 방식의 키값 변수 적용은 불가능
  man[v]; // man['age'] 대괄호를 씀으로써 키값에 변수를 적용할 수 있다.

  console.log(man.name)
  console.log(man.age)
  console.log(man['name']) // 객체의 키값에 접근하는 또 다른 방법
  console.log(man['age'])

  // input 태그에 입력한 모든 내용을 저장하기 위한 state 변수
  const [inputData, setInputData] = useState({
    name: '',
    age: '',
    addr: ''
  })

  console.log(inputData)

  // input 태그의 값을 입력할 때마다 실행시키는 함수
  const handleInputData = e => {
    setInputData({
      ...inputData,
      [e.target.name]: e.target.value // 대괄호를 이용함으로써 e.target.name의 값을 이용할 수 있다. 괄호를 없애면 e.target.name자체로 해석하여 그 키 값을 찾음
    })
  }

  return(
    <div>
      <p>이름</p>
      <input
       type="text" 
       name="name"
       value={inputData.name} 
       onChange={e => handleInputData(e)} 
      />
      <p>나이</p>
      <input
       type="text"
       name="age" 
       value={inputData.age} 
       onChange={e => handleInputData(e)} 
      />
      <p>주소</p>
      <input
       type="text"
       name="addr" 
       value={inputData.addr}
       onChange={e => handleInputData(e)} 
      />
    </div>
  )
}

export default InputTest4