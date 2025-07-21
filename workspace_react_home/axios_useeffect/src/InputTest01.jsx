import axios from "axios"
import { useState } from "react"

const InputTest01 = () => {

  const [memberInfo, setMemberInfo] = useState({
    name: '',
    age: 1,
    birth: ''
  })

  const regMember = () => {
    axios.post('/api/members', memberInfo)
    .then(res => console.log(res.data))
    .catch(error => console.log(error))
  }

  console.log(memberInfo)
  return(
    <div>
      <p>이름</p>
      <input type="text" value={memberInfo.name} onChange={e => {
        setMemberInfo({
          ...memberInfo,
          name: e.target.value
        })
      }} />
      <p>나이</p>
      <input type="text" value={memberInfo.age} onChange={e => {
        setMemberInfo({
          ...memberInfo,
          age: e.target.value
        })
      }} />
      <p>생년월일</p>
      <input type="text" value={memberInfo.birth} onChange={e => {
        setMemberInfo({
          ...memberInfo,
          birth: e.target.value
        })
      }} />

      <button type='button' onClick={() => regMember()}>등록</button>
    </div>
  )
}

export default InputTest01