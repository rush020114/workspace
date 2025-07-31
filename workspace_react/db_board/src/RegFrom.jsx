import axios from 'axios'
import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import styles from './RegForm.module.css'

const RegFrom = ({nav}) => {

  const [regBoardData, setRegBoardData] = useState({
    title: ''
    , writer: ''
    , content: ''
  })

  const handleRegBoard = e => {
    setRegBoardData({
      ...regBoardData
      , [e.target.name]: e.target.value
    })
  }

  const regBoard = () => {
    if(regBoardData.title === '' || regBoardData.writer === ''){
      alert('제목 또는 작성자를 입력해주세요.')
      return
    }
    axios.post('/api/boards', regBoardData)
    .then(res => nav('/'))
    .catch(error => console.log(error))
  }

  return (
    <div className={styles.container}>
      <div className={styles.title_div}>
        <h1>게시글 작성 페이지</h1>
      </div>
      <div className={styles.reg_div}>
        <table className={styles.reg_table}>
          <tbody>
            <tr>
              <td>제목</td>
              <td>
                <input
                 type="text"
                 name='title'
                 value={regBoardData.title}
                 onChange={e => handleRegBoard(e)} 
                />
              </td>
            </tr>
            <tr>
              <td>작성자</td>
              <td>
                <input
                 type="text"
                 name='writer'
                 value={regBoardData.writer}
                 onChange={e => handleRegBoard(e)} 
                />
              </td>
            </tr>
            <tr>
              <td>내용</td>
              <td>
                <textarea
                 rows={5}
                 type="text"
                 name='content'
                 value={regBoardData.content}
                 onChange={e => handleRegBoard(e)} 
                ></textarea>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
      <div className={styles.btn_div}>
        <button
         type='button'
         onClick={e => {
          regBoard()
        }}
        >글등록</button>
      </div>
    </div>
  )
}

export default RegFrom