import axios from 'axios'
import React, { useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom'
import styles from './BoardDetail.module.css'

const BoardDetail = ({nav}) => {

  const {boardNum} = useParams()

  const [boardData, setBoardData] = useState({})

  useEffect(() => {
    axios.get(`/api/boards/${boardNum}`)
    .then(res => setBoardData(res.data))
    .catch(error => console.log(error))
  }, [])

  const deleteBoard = () => {
    const result = confirm('정말 삭제하시겠습니까?');
    result
    &&
    axios
    .delete(`/api/boards/${boardNum}`)
    .then(res => {
      alert('한 개의 글이 삭제되었습니다.')
      nav('/')
    })
    .catch(error => console.log(error))
  }

  return (
    <div className={styles.container}>
      <div className={styles.title_div}>
        <h1>게시글 상세 정보 페이지</h1>
      </div>
      <div className={styles.detail_div}>
        <table className={styles.detail_table}>
          <tbody>
            <tr>
              <td>작성일</td>
              <td>{boardData.createDate}</td>
              <td>작성자</td>
              <td>{boardData.writer}</td>
              <td>조회수</td>
              <td>{boardData.readCnt}</td>
            </tr>
            <tr>
              <td>제목</td>
              <td colSpan={5}>{boardData.title}</td>
            </tr>
            <tr>
              <td>내용</td>
              <td colSpan={5}>{boardData.content}</td>
            </tr>
          </tbody>
        </table>
      </div>
      <div className={styles.btn_div}>
        <button
         type='button'
         onClick={e => nav(-1)}
         >목록가기</button>
        <button
         type='button'
         onClick={e => nav(`/${boardNum}/update`)}
        >수정</button>
        <button
         type='button'
         onClick={e => deleteBoard()}
        >삭제</button>
      </div>
    </div>
  )
}

export default BoardDetail