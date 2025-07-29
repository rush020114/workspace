import axios from 'axios'
import React, { useState } from 'react'

const SearchBoardList = () => {

  const [boardData, setBoardData] = useState({title: ''})
  const [boardList, setBoardList] = useState([])

  const handleBoardData = e => {
    setBoardData({
      ...boardData
      , [e.target.name]: e.target.value
    })
  }

  const getBoard = () => {
    axios.get(`/api/boards/${boardData.title}`)
    .then(res => setBoardList(res.data))
    .catch()
  }

  console.log(boardData.title)
  console.log(boardList)

  return (
    <div>
      <h1>게시글 목록 페이지2</h1>
      <div>
        <p>제목</p>
        <input
         type="text" 
         name='title'
         value={boardData.title}
         onChange={e => handleBoardData(e)}
        />
        <button
         type='button'
         onClick={e => getBoard(boardData)}
        >조회</button>
      </div>
      <table>
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
            boardList.map((board, i) => {
              return(
                <tr key={i}>
                  <td>{boardList.length - i}</td>
                  <td>{board.title}</td>
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
  )
}

export default SearchBoardList