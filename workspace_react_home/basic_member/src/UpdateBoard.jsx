import axios from 'axios'
import React, { useState } from 'react'

const UpdateBoard = () => {

  const [updateBoardData, setUpdataBoardData] = useState({
    boardNum: ''
    , title: ''
    , readCnt: '' 
  })

  const handleBoardData = e => {
    setUpdataBoardData({
      ...updateBoardData
      , [e.target.name]: e.target.value
    })
  }

  const updateBoard = () => {
    axios.put(`api/boards/${updateBoardData.boardNum}`, updateBoardData)
    .then(res => alert(res.data !== 0 ? `${boardNum}개의 글이 수정되었습니다.` : '수정실패'))
    .catch(error => console.log(error))
  }

  console.log(updateBoardData)

  return (
    <div>
      <div>
        <p>글번호</p>
        <input
         type="text"
         name='boardNum' 
         value={updateBoardData.boardNum}
         onChange={e => handleBoardData(e)}
         />
        <p>제목</p>
        <input
         type="text"
         name='title' 
         value={updateBoardData.title}
         onChange={e => handleBoardData(e)}
         />
        <p>조회수</p>
        <input
         type="text"
         name='readCnt' 
         value={updateBoardData.readCnt}
         onChange={e => handleBoardData(e)}
        />
      </div>
      <div>
        <button
         type='button'
         onClick={e => updateBoard()}
        >수정</button>
      </div>
    </div>
  )
}

export default UpdateBoard