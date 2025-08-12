import { useEffect, useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import axios from 'axios';

function App() {

  // 조회된 학급명을 받기 위한 state 변수
  const [classNameList, setClassNameList] = useState([]);

  // 학급명 선택을 위한 state 변수
  const [selectedClassNum, setSelectedClassNum] = useState("");

  // 선택된 학생목록을 조회하기 위한 state변수
  const [stuList, setStuList] = useState([]);

  // 학급명을 조회하기 위한 useEffect
  useEffect(() => {
    axios.get('/api/classes')
    .then(res => setClassNameList(res.data))
    .catch(e => console.log(e));
  }, []);

  // 학생 목록을 조회하기 위한 useEffect
  useEffect(() => {
    axios.get('/api/students')
    .then(res => setStuList(res.data))
    .catch(e => console.log(e))
  }, [])

  // 선택된 학생 목록을 조회하기 위한 useEffect
  useEffect(() => {
    selectedClassNum &&
    axios.get(`/api/students/${selectedClassNum}`)
    .then(res => setStuList(res.data))
    .catch(e => console.log(e))
  }, [selectedClassNum])

  // 다시 전체를 선택했을 때 전체를 조회하기 위한 useEffect
  useEffect(() => {
    selectedClassNum ||
    axios.get(`/api/students`)
    .then(res => setStuList(res.data))
    .catch(e => console.log(e))
  }, [selectedClassNum])

  console.log(selectedClassNum);

  return (
    <div className='container'>
      <div className='select'>
        <select 
         name=""
         value={selectedClassNum}
         onChange={e => setSelectedClassNum(e.target.value)}
        >
          <option value={""}>전체</option>
          {
            classNameList.length &&
            classNameList.map((classInfo, i) => {
              return(
                <option
                 key={i}
                 value={classInfo.classNum}
                >{classInfo.className}</option>
              );
            })
          }
        </select>
      </div>
      <table className='table'>
        <thead>
          <tr>
            <td>No</td>
            <td>학생명</td>
            <td>나이</td>
          </tr>
        </thead>
        <tbody>
          {
            stuList.map((stu, i) => {
              return(
                <tr key={i}>
                  <td>{i + 1}</td>
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

export default App
