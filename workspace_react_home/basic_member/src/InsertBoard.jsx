import axios from 'axios'
import React, { useState } from 'react'

const InsertBoard = () => {

  const [insertBoardData, setInsertBoardData] = useState({
    title: '',
    writer: '',
    content: ''
  })

  const handleBoardData = e => {
    setInsertBoardData({
      ...insertBoardData
      , [e.target.name]: e.target.value
    })
  }

  const insertBoard = () => {
    axios.post('/api/boards', insertBoardData)
    .then(res => alert(res.data === 1 ? '등록성공' : '등록실패'))
    .catch(error => console.log(error))
  }

  return (
    <div>
      <div>
        <p>제목</p>
        <input
         type="text" 
         name="title"
         value={insertBoardData.title}
         onChange={e => handleBoardData(e)}
        />
        <p>작성자</p>
        <input
         type="text" 
         name="writer"
         value={insertBoardData.writer}
         onChange={e => handleBoardData(e)}
        />
        <p>내용</p>
        <textarea
         cols={50}
         rows={5}
         name="content"
         value={insertBoardData.content}
         onChange={e => handleBoardData(e)}
        ></textarea>
      </div>
      <div>
        <button
         type='button'
         onClick={e => insertBoard()}
        >등록</button>
      </div>
    </div>
  )
}

export default InsertBoard