import axios from 'axios';
import React, { useEffect, useState } from 'react'

const StuList = () => {

  // 학급 목록을 받을 state 변수
  const [classInfo, setClassInfo] = useState([]);

  // 학생 목록을 받을 state 변수
  const [stuList, setStuList] = useState([]);

  // 학급 목록과 학생 목록을 함께 조회할 useEffect
  useEffect(() => {
    axios.all([
      axios.get('/api/classes')
      , axios.get(`/api/students`)
    ])
    .then(axios.spread((res1, res2) => {
      setClassInfo(res1.data);
      setStuList(res2.data);
    }))
    .catch(e => console.log(e));
  }, []);

  // 선택된 반의 학생목록을 가져올 함수
  const getStuList = classNum => {
    axios.get(`/api/students/${classNum}`)
    .then(res => setStuList(res.data))
    .catch(e => console.log(e));
  };

  return (
    <div>
      <select
       onChange={e => getStuList(e.target.value)}
      >
        <option value={0}>전체</option>
        {
          classInfo.map((e, i) => {
            return(
              <option
               key={i}
               value={e.classNum}
              >{e.className}</option>
            )
          })
        }
      </select>
      <table>
        <thead>
          <tr>
            <td>No</td>
            <td>학급명</td>
            <td>이름</td>
            <td>나이</td>
          </tr>
        </thead>
        <tbody>
          {
            stuList.map((stu, i) =>{
              return(
                <tr key={i}>
                  <td>{i + 1}</td>
                  <td>{stu.classDTO.className}</td>
                  <td>{stu.stuName}</td>
                  <td>{stu.stuAge}</td>
                </tr>
              )
            })
          }
        </tbody>
      </table>
    </div>
  )
}

export default StuList