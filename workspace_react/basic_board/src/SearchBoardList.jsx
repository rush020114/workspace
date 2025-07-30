import axios from 'axios'
import React, { useState } from 'react'
import './SearchBoardList.css'

const SearchBoardList = () => {

  const [title, setTitle] = useState('')

  const [boardList, setBoardList] = useState([])

  const [isShow, setIsShow] = useState(false)

  const getBoard = () => {
    axios.get(`/api/boards/search/${title}`)
    .then(res => {
        setBoardList(res.data)
        console.log(res.data)
        setIsShow(true)
      })
    .catch(error => console.log(error))
  }

  console.log(title)
  console.log(boardList)

  return (
    <div className='search-container'>
      <h1>게시글 목록 페이지2</h1>
      <div className='search-div'>
        <p>제목</p>
        <input
         type="text" 
         value={title}
         onChange={e => setTitle(e.target.value)}
         onKeyDown={e => {
          if(e.key === 'Enter'){
            getBoard()
          }
         }}
        />
        <button
         type='button'
         onClick={e => getBoard(title)}
        >조회</button>
      </div>
      {
        isShow
        &&
        <table className='search-table'>
          <colgroup>
            <col width='7%' />
            <col width='25%' />
            <col width='18%' />
            <col width='*%' />
            <col width='10%' />
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
              boardList.length !== 0
              ?
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
              :
              <tr>
                <td colSpan={5}>조회된 데이터가 없습니다.</td>
              </tr>
            }
          </tbody>
        </table>
      }
    </div>
  )
}

export default SearchBoardList