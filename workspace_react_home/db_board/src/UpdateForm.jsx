import axios from 'axios'
import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom'
import styles from './UpdateForm.module.css'

const UpdateForm = ({nav}) => {

  const {boardNum} = useParams()

  const [board, setBoard] = useState({})

  const [updateBoardDate, setUpdateBoardDate] = useState({
    title: ''
    , content: ''
  })

  const handleUpdateBoard = e => {
    setUpdateBoardDate({
      ...updateBoardDate
      , [e.target.name]: e.target.value
    })
  }

  useEffect(() => {
    axios.get(`/api/boards/${boardNum}`)
    .then(res => setBoard(res.data))
    .catch()
  }, [])

  const updateBoard = () => {

    axios.put(`/api/boards/${boardNum}`, updateBoardDate)
    .then(res => alert('수정완료'))
    .catch(error => console.log(error))
    nav(-1)
  }

  return (
    <div className={styles.container}>
      <h1 className={styles.title}>게시글 수정 페이지</h1>
      <table className={styles.table}>
        <tbody>
          <tr>
            <td>작성일</td>
            <td>{board.createDate}</td>
            <td>작성자</td>
            <td>{board.writer}</td>
          </tr>
          <tr>
            <td>제목</td>
            <td colSpan={3}>
              <input 
               type="text" 
               name='title'
               value={updateBoardDate.title}
               onChange={e => handleUpdateBoard(e)}
               />
            </td>
          </tr>
          <tr>
            <td>내용</td>
            <td colSpan={3}>
              <textarea
               rows={5}
               name="content"
               value={updateBoardDate.content}
               onChange={e => handleUpdateBoard(e)}
              ></textarea>
            </td>
          </tr>
        </tbody>
      </table>
      <div className={styles.btn_div}>
        <button
         type='button'
         onClick={e => nav(-1)}
        >뒤로가기</button>
        <button
         type='button'
         onClick={e => updateBoard()}
        >수정</button>
      </div>
    </div>
  )
}

export default UpdateForm