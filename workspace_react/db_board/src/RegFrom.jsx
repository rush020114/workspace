import axios from 'axios'
import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom'

const RegFrom = () => {

  const nav = useNavigate()

  const [regBoardData, setRegBoardData] = useState({
    title: ''
    , writer: ''
    , content: ''
  })

  console.log(regBoardData)

  const handleRegBoard = (e) => {
    setRegBoardData({
      ...regBoardData
      , [e.target.name]: e.target.value
    })
  }

  const regBoard = () => {
    axios.post('/api/boards', regBoardData)
    .then(res => alert(res.data === 0 ? '등록실패' : '등록성공'))
    .catch(error => console.log(error))
  }

  return (
    <div>
      <h1>게시글 작성 페이지</h1>
      <table>
        <tbody>
          <tr>
            <td>제목</td>
            <td>
              <input
               type="text"
               name='title'
               value={regBoardData.title}
               onChange={e => handleRegBoard(e)} 
              />
            </td>
          </tr>
          <tr>
            <td>작성자</td>
            <td>
              <input
               type="text"
               name='writer'
               value={regBoardData.writer}
               onChange={e => handleRegBoard(e)} 
              />
            </td>
          </tr>
          <tr>
            <td>내용</td>
            <td>
              <textarea
               type="text"
               name='content'
               value={regBoardData.content}
               onChange={e => handleRegBoard(e)} 
              ></textarea>
            </td>
          </tr>
        </tbody>
      </table>
      <div>
        <button
         type='button'
         onClick={e => {
          regBoard()
          nav('/home')
        }}
        >글등록</button>
      </div>
    </div>
  )
}

export default RegFrom