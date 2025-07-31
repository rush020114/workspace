import axios from 'axios'
import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom'
import styles from './BoardDetail.module.css'

const BoardDetail = ({nav}) => {

  const {boardNum} = useParams()

  const [boardDetail, setBoardDetail] = useState({})

  useEffect(() => {
    axios.get(`/api/boards/${boardNum}`)
    .then(res => setBoardDetail(res.data))
    .catch(error => console.log(error))
  }, [])

  const deleteBoard = () => {
    confirm('정말로 글을 삭제하시겠습니까?') &&
    axios.delete(`/api/boards/${boardNum}`)
    .then(res => {
      alert('삭제 성공')
      nav('/')
    })
    .catch(error => console.log(error))
  }

  return (
    <div className={styles.container}>
      <h1 className={styles.title}>게시글 상세 정보 페이지</h1>
      <table className={styles.table}>
        <tbody>
          <tr>
            <td>작성일</td>
            <td>{boardDetail.createDate}</td>
            <td>작성자</td>
            <td>{boardDetail.writer}</td>
            <td>조회수</td>
            <td>{boardDetail.readCnt}</td>
          </tr>
          <tr>
            <td>제목</td>
            <td colSpan={5}>{boardDetail.title}</td>
          </tr>
          <tr>
            <td>내용</td>
            <td colSpan={5}>{boardDetail.content}</td>
          </tr>
        </tbody>
      </table>
      <div className={styles.btn_div}>
        <button
         type='button'
         onClick={e => nav('/')}
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