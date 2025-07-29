import axios from 'axios'
import React, { useState } from 'react'

const DeleteBoard = () => {

  const [boardNum, setBoardNum] = useState('')

  const deleteBoard = () => {
    axios.delete(`/api/boards/${boardNum}`)
    .then(res => alert(res.data !== 0 ? `${res.data}개의 글이 삭제되었습니다.` : '삭제 실패'))
    .catch(error => console.log(error))
  }

  return (
    <div>
      <div>
        <p>글번호</p>
        <input
         type="text" 
         name='boardNum'
         value={boardNum}
         onChange={e => setBoardNum(e.target.value)}
        />
      </div>
      <div>
        <button
         type='button'
         onClick={e => deleteBoard()}
        >삭제</button>
      </div>
    </div>
  )
}

export default DeleteBoard