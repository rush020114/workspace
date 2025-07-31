import axios from 'axios'
import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom'
import styles from './BoardList.module.css'

const BoardList = ({nav}) => {

  const [boardList, setBoardList] = useState([])

  useEffect(() => {
    axios.get('/api/boards')
    .then(res => setBoardList(res.data))
    .catch(error => console.log(error))
  }, [])

  const updateReadCnt = (boardNum) => {
    axios.put(`/api/boards/read-cnt/${boardNum}`)
    .then(res => console.log(res.data))
    .catch(error => console.log(error))
  }

  return (
    <div className={styles.container}>
      <div className={styles.title_div}>
        <h1>자유게시판</h1>
      </div>
      <div className={styles.search_div}>
        <select name="">
          <option value="">제목</option>
          <option value="">작성자</option>
        </select>
        <input type="text" />
        <button type='button'>검색</button>
      </div>
      <div className={styles.list_div}>
        <table className={styles.list_table}>
          <colgroup>
            <col width='' />
            <col width='' />
            <col width='' />
            <col width='' />
            <col width='' />
          </colgroup>
          <thead>
            <tr>
              <td>No</td>
              <td>제목</td>
              <td>작성자</td>
              <td>작성일</td>
              <td>조회수</td>
            </tr>
          </thead>
          <tbody>
            {
              boardList.length === 0
              ?
              <tr>
                <td colSpan={5}>조회된 게시글이 없습니다.</td>
              </tr>
              :
              boardList.map((board, i) => {
                return(
                  <tr key={i}>
                    <td>{boardList.length - i}</td>
                    <td>
                      <span 
                      className={styles.clickable}
                      onClick={e => {
                        const boardNum = board.boardNum
                        updateReadCnt(boardNum)
                        nav(`/${boardNum}`)
                      }}
                      >
                        {board.title}
                      </span>
                    </td>
                    <td>{board.writer}</td>
                    <td>{board.createDate}</td>
                    <td>{board.readCnt}</td>
                  </tr>
                )
              })
            }
          </tbody>
        </table>
      </div>
      <div className={styles.btn_div}>
        <button
         type='button'
         onClick={e => nav('/reg')}
        >글쓰기</button>
      </div>
    </div>
  )
}

export default BoardList