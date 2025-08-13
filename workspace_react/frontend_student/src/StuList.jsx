import axios from 'axios';
import React, { useEffect, useState } from 'react'
import styles from './StuList.module.css'

const StuList = () => {

  // 조회된 학급명을 받기 위한 state 변수
  const [classNameList, setClassNameList] = useState([]);

  // 선택된 학생목록을 조회하기 위한 state변수
  const [stuList, setStuList] = useState([]);

  // 학급목록과 학생목록을 동시에 조회
  useEffect(() => {
    axios.all([axios.get('/api/classes'), axios.get('/api/students')])
    .then(axios.spread((res1, res2) => {
      setClassNameList(res1.data);
      setStuList(res2.data);
    }))
    .catch(e => console.log(e));
  }, []);

  // 셀렉트 박스의 값이 바뀌면 학생 목록을 다시 조회하는 함수
  const getStuList = classNum => {
    // 선택한 반번호
    axios.get(`/api/students/${classNum}`)
    .then(res => setStuList(res.data))
    .catch(e => console.log(e));
  };

  console.log(stuList);

  return (
    <div className={styles.container}>
      <div className={styles.select}>
        <select 
         onChange={e => getStuList(e.target.value)}
        >
          <option value="0">전체</option>
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
      <table className={styles.table}>
        <thead>
          <tr>
            <td>No</td>
            <td>학급명</td>
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