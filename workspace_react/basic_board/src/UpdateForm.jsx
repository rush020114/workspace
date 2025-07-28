import axios from "axios"
import { useState } from "react"

const UpdateForm = () => {

  const [boardData, setBoardData] = useState({
    boardNum: ''
    , title: ''
    , content: ''
  })

  const handleBoardData = e => {
    setBoardData({
      ...boardData
      , [e.target.name]: e.target.value
    })
  }

  const updateBoard = () => {
    axios.put(`/api/boards/${boardData.boardNum}`, boardData)
    .then(res => alert(`${res.data}개의 게시글이 수정되었습니다.`))
    .catch(error => console.log(error))
  }

  console.log(boardData)

  return(
    <div>
      <h2>게시글 정보 수정</h2>
      <div>
        <div>
          <p>글번호</p>
          <input
           type="text"
           value={boardData.boardNum} 
           name="boardNum"
           onChange={e => handleBoardData(e)}
           />
        </div>
        <div>
          <p>제목</p>
          <input
           type="text" 
           value={boardData.writer}
           name="title"
           onChange={e => handleBoardData(e)}
           />
        </div>
        <div>
          <p>내용</p>
          <textarea
           value={boardData.content}
           name="content"
           onChange={e => handleBoardData(e)}
          ></textarea>
        </div>
      </div>
      <div>
        <button
         type="button"
         onClick={e => updateBoard()}
        >수정</button>
      </div>
    </div>
  )
}

export default UpdateForm