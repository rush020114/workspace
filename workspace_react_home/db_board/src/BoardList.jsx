import axios from 'axios'
import React, { useEffect, useState } from 'react'

const BoardList = ({nav, setSelectedBoard}) => {

  const [boardList, setBoardList] = useState([])

  useEffect(() => {
    axios.get('/api/boards')
    .then(res => setBoardList(res.data))
    .catch(error => console.log(error))
  }, [])

  return (
    <div>
      <h1>자유게시판</h1>
      <div>
        <select name="">
          <option value="">제목</option>
        </select>
        <input type="text" />
        <button type='button'>검색</button>
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
                  <td onClick={e => {
                    setSelectedBoard(board)
                    nav(`${board.boardNum}`)
                    }}>{board.title}</td>
                  <td>{board.writer}</td>
                  <td>{board.createDate}</td>
                  <td>{board.readCnt}</td>
                </tr>
              )
            })
          }
        </tbody>
      </table>
      <div>
        <button
         type='button'
         onClick={e => nav('/reg')}
        >글쓰기</button>
      </div>
    </div>
  )
}

export default BoardList