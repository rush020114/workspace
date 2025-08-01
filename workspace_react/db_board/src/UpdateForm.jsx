import axios from 'axios'
import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom'
import styles from './UpdateForm.module.css'

const UpdateForm = ({nav}) => {

  const {boardNum} = useParams()

  const [boardData, setBoardData] = useState({})

  console.log(boardData)

  useEffect(() => {
    axios.get(`/api/boards/${boardNum}`)
    .then(res => setBoardData(res.data))
    .catch(error => console.log(error))
  }, [])

  const [updateBoardData, setUpdateBoardData] = useState({
    title: ''
    , content: ''
  })

  // boardData가 값이 바뀔 때만 실행 + 마운트 시에도 실행 x
  // 의존성 배열에 board를 넣으면 board 값이 바뀌어서 리렌더링될 때도 실행
  useEffect(() => {
    boardData.title !== undefined
    && 
    setUpdateBoardData({
      title: boardData.title
      , content: boardData.content
    })
  }, [boardData])

  const handleUpdateBoard = e => {
    setUpdateBoardData({
      ...updateBoardData
      , [e.target.name]: e.target.value
    })
  }

  const updateBoard = () => {
    if(updateBoardData.title === ''){
      alert('제목을 입력해주세요.')
      return
    }
    axios.put(`/api/boards/${boardNum}`, updateBoardData)
    .then(res => nav(`/${boardNum}`))
    .catch(error => console.log(error))
  }

  return (
    <div className={styles.container}>
      <div className={styles.title_div}><h1>게시글 수정 페이지</h1></div>
      <div className={styles.update_div}>
        <table className={styles.update_table}>
          <tbody>
            <tr>
              <td>작성일</td>
              <td>{boardData.createDate}</td>
              <td>작성자</td>
              <td>{boardData.writer}</td>
            </tr>
            <tr>
              <td>제목</td>
              <td colSpan={3}>
                <input 
                 type="text" 
                 name='title'
                 value={updateBoardData.title}
                 onChange={e => handleUpdateBoard(e)}
                 />
              </td>
            </tr>
            <tr>
              <td>내용</td>
              <td colSpan={3}>
                <textarea
                 rows={5}
                 name='content'
                 value={updateBoardData.content}
                 onChange={e => handleUpdateBoard(e)}
                ></textarea>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
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