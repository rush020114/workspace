import axios from 'axios';
import React, { useEffect, useState } from 'react'

const Axios_3 = () => {
  // state 변수의 초기값은 최종데이터의 자료형과 일치시켜주는 것이 좋음
  // 객체의 데이터를 받아와 반영된 값을 화면에 출력하기 위해 useState초기값을 빈객체로 주었다.
  const [stu, setStu] = useState({}); 

  useEffect(() => {
    axios.get('/api/getStu')
    .then((res) => {
      console.log(res.data)
      setStu(res.data)
    })
    .catch((error) => console.log(error))
  }, [])


  return (
    <>
      <div>이름 : {stu.name}</div>
      <div>국어 : {stu.korScore}</div>
      <div>영어 : {stu.engScore}</div>
    </>
  )
}

export default Axios_3