import axios from 'axios'
import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom'

const RegForm = ({nav}) => {

  const [regBoardData, setRegBoardData] = useState({
    title: ''
    , writer: ''
    , content: ''
  })

  const handleRegBoard = e => {setRegBoardData({
    ...regBoardData
    , [e.target.name]: e.target.value
  })}

  const regBoard = () => {
    axios.post('/api/boards', regBoardData)
    .then(res => {
      console.log(res.data)
      if(res.data === 0){
        alert('제목 또는 작성자를 입력해주세요.')
        return
      }
      nav('')
    })
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
      <button
       type='button'
       onClick={e => {
        regBoard()
      }}
      >등록</button>
    </div>
  )
}

export default RegForm