import axios from 'axios'
import React, { useEffect, useState } from 'react'
import './Axios_4.css'

const Axios_4 = () => {
  const [stuList, setStuList] = useState([])
  const [btn, setBtn] = useState('목록조회')
  const [isShow, setIsShow] = useState(false)

  useEffect(() => {
    axios.get('/api/stuList')
    .then((res) => {
      console.log(res.data)
      setStuList(res.data)
    })
    .catch((error) => console.log(error))
  },[])

  return (
    <div className='container'>
      <button type='button' onClick={() => {
        setBtn(btn === '목록조회' ? '목록숨김' : '목록조회')
        setIsShow(!isShow)
      }}>{btn}</button>
      <table>
        <colgroup>
          <col width='*'/>
          <col width='22%'/>
          <col width='22%'/>
          <col width='22%'/>
          <col width='22%'/>
        </colgroup>
        <thead>
          <tr>
            <td>No</td>
            <td>이름</td>
            <td>국어점수</td>
            <td>영어점수</td>
            <td>총점</td>
          </tr>
        </thead>
        <tbody>
          {
            isShow === true ?
            stuList.map((student, i) => {
              return(
                <tr key={i}>
                  <td>{i + 1}</td>
                  <td>{student.name}</td>
                  <td>{student.korScore}</td>
                  <td>{student.engScore}</td>
                  <td>{student.korScore + student.engScore}</td>
                </tr>
              )
            })
            :
            <tr>
              <td colSpan={5}>버튼을 클릭하면 학생 목록이 조회됩니다.</td>
            </tr>
          }
        </tbody>
      </table>
    </div>
  )
}

export default Axios_4