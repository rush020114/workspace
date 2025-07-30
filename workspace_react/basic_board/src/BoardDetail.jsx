import axios from 'axios'
import React, { useEffect, useState } from 'react'
import './BoardDetail.css'

const BoardDetail = () => {

  const [boardNum, setBoardNum] = useState('')

  const [board, setBoard] = useState({})

  const [isShow, setIsShow] = useState(false)

  console.log(board.title)
  
  const getBoard = (boardNum) => {
    if(boardNum === ''){
      alert('번호를 입력하세요')
      return
    }
    axios.get(`/api/boards/${boardNum}`)
    .then(res => {
      setIsShow(true)
      console.log(res.data)
      if(res.data === ''){
        alert('조회실패')
        setIsShow(false)
      }
      setBoard(res.data)
    })
    .catch(error => console.log(error))
  }

  return (
    <div className='detail-container'>
      <h1>게시글 상세 정보 조회 페이지</h1>
      <div className='detail-div'>
        <p>조회할 게시글 번호를 입력하세요</p>
        <input
         type="text" 
         value={boardNum}
         onChange={e => setBoardNum(e.target.value)}
        />
        <button
         type='button'
         onClick={e => getBoard(boardNum)}
        >조회</button>
      </div>
      {
        isShow
        &&
        <table className='detail-table'>
          <colgroup>
            <col width='25%' />
            <col width='25%' />
            <col width='25%' />
            <col width='25%' />
          </colgroup>
          <tbody>
            <tr>
              <td>글번호</td>
              <td>{board.boardNum}</td>
              <td>조회수</td>
              <td>{board.readCnt}</td>
            </tr>
            <tr>
              <td>작성자</td>
              <td>{board.writer}</td>
              <td>작성일자</td>
              <td>{board.createDate}</td>
            </tr>
            <tr>
              <td>제목</td>
              <td colSpan={3}>{board.title}</td>
            </tr>
            <tr>
              <td>내용</td>
              <td colSpan={3}>{board.content}</td>
            </tr>
          </tbody>
        </table>
      }
    </div>
  )
}

export default BoardDetail