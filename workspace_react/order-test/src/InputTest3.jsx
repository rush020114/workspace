import axios from "axios"
import { useState } from "react"

const InputTest3 = () => {

  const [studentInfo, setStudentInfo] = useState({name: '', korScore: 0, engScore: 0, addr: ''})

  console.log(studentInfo)

  const regStudent = () => {
    axios.post('/api/students', studentInfo)
    .then(res => console.log(res.data))
    .catch(error => console.log(error))
  }

  return(
    <div>
      <span>이름: </span>
      <input type="text" value={studentInfo.name} onChange={e => {
        setStudentInfo({
          ...studentInfo,
          name: e.target.value
        })
      }} /> <br />
      <span>국어점수: </span>
      <input type="text" value={studentInfo.korScore} onChange={e => {
        setStudentInfo({
          ...studentInfo,
          korScore: e.target.value
        })
      }} /> <br />
      <span>영어점수: </span>
      <input type="text" value={studentInfo.engScore} onChange={e => {
        setStudentInfo({
          ...studentInfo,
          engScore: e.target.value
        })
      }} /> <br />
      <span>주소: </span>
      <input type="text" value={studentInfo.addr} onChange={e => {
        setStudentInfo({
          ...studentInfo,
          addr: e.target.value
        })
      }} /> <br />

      <button type="button" onClick={e => regStudent()}>학생 정보 전달</button>
    </div>
  )
}

export default InputTest3