import axios from 'axios'
import React, { useEffect, useState } from 'react'
import './BoardDetail.css'

const BoardDetail = () => {

  const [boardData, setBoardData] = useState({boardNum: ''})

  const [board, setBoard] = useState({})

  const [isShow, setIsShow] = useState(false)

  const getBoard = (boardNum) => {
    axios.get(`/api/boards/${boardNum}`)
    .then(res => setBoard(res.data))
    .catch(error => console.log(error))
  }
  
  const handleBoardData = (e) => {
    setBoardData({
      ...boardData
      , [e.target.name]: e.target.value
    })
  }

  console.log(boardData)

  return (
    <div className='detail-container'>
      <h1>게시글 상세 정보 조회 페이지</h1>
      <div className='detail-div'>
        <p>조회할 게시글 번호를 입력하세요</p>
        <input
         type="text" 
         name='boardNum'
         value={boardData.boardNum}
         onChange={e => handleBoardData(e)}
        />
        <button
         type='button'
         onClick={e => {
          getBoard(boardData.boardNum)
          setIsShow(true)
        }}
        >조회</button>
      </div>
      {
        isShow
        ?
        <table className='detail-table'>
          <tbody>
            <tr>
              <td>글번호</td>
              <td>{board.boardNum}</td>
              <td>조회수</td>
              <td>{board.readCnt}</td>
            </tr>
            <tr>
              <td>제목</td>
              <td>{board.title}</td>
              <td>작성일자</td>
              <td>{board.createDate}</td>
            </tr>
            <tr>
              <td>제목</td>
              <td colSpan={3}>게시글</td>
            </tr>
            <tr>
              <td>내용</td>
              <td colSpan={3}>{board.content}</td>
            </tr>
          </tbody>
        </table>
        :
        null
      }
    </div>
  )
}

export default BoardDetail