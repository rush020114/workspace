import axios from 'axios'
import React, { useState } from 'react'

const BoardDetail = () => {

  const [boardNum, setBoardNum] = useState('')

  const [board, setBoard] = useState({});

  const getBoard = () => {
    axios.get(`/api/boards/${boardNum}`)
    .then(res => {
      setBoard(res.data)
      console.log(res.data)
    })
    .catch(error => console.log(error))
    alert(boardNum !== undefined ? '게시글이 존재하지 않음' : '조회 성공') 
  }

  console.log(board.boardNum)

  return (
    <div>
      <h1>게시글 상세 정보 조회 페이지</h1>
      <div>
        <p>조회할 게시글 번호를 입력하세요</p>
        <input
         type="text" 
         name='boardNum'
         value={boardNum}
         onChange={e => setBoardNum(e.target.value)}
        />
        <button
         type='button'
         onClick={e => getBoard()}
        >조회</button>
      </div>
      {
        board.boardNum !== undefined
        ?
        <table>
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
        :
        null
      }
    </div>
  )
}

export default BoardDetail