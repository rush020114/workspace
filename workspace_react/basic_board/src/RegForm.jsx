import axios from "axios"
import { useState } from "react"

const RegForm = () => {

  const [boardData, setBoardData] = useState({
    title: '',
    writer: '',
    content: '',
    readCnt: 0
  })

  console.log(boardData)

  const handleBoardData = e => {
    setBoardData({
      ...boardData,
      [e.target.name]: e.target.value
    })
  }

  const regBoard = () => {
    axios.post('/api/boards', boardData)
    .then(res => alert('등록 성공!'))
    .catch(error => console.log(error))
  }

  return (
    <div>
      <h3>게시글 등록</h3>
      <p>제목</p>
      <input
       type="text"
       value={boardData.title}
       name="title"
       onChange={e => handleBoardData(e)} 
       />
      <p>작성자</p>
      <input
       type="text"
       value={boardData.writer}
       name="writer" 
       onChange={e => handleBoardData(e)} 
       />
      <p>내용</p>
      <textarea
       cols={50}
       rows={10}
       value={boardData.content}
       name="content"
       onChange={e => handleBoardData(e)} 
       >
      </textarea>
      <p>조회수</p>
      <input
       type="text"
       value={boardData.readCnt}
       name="readCnt" 
       onChange={e => handleBoardData(e)} 
       />
      <div>
        <button
         type="button"
         onClick={e => regBoard()}
         >등록</button>
      </div>
    </div>
  )
}

export default RegForm