import axios from 'axios'
import React, { useState } from 'react'

const SearchBoardList = () => {

  const [title, setTitle] = useState('')

  const [boardList, setBoardList] = useState([])

  const getBoard = () => {
    axios.get(`/api/boards/${title}`)
    .then(res => setBoardList(res.data))
    .catch(error => console.log(error))
  }

  console.log(title)

  return (
    <div>
      <h1>게시글 목록 페이지2</h1>
      <div>
        <p>제목</p>
        <input
         type="text"
         name=''
         value={title}
         onChange={e => setTitle(e.target.value)} 
        />
        <button
         type='button'
         onClick={e => getBoard()}
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