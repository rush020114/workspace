import axios from "axios"
import { useState } from "react"

const DeleteForm = () => {

  const [boardNum, setBoardData] = useState('')

  const deleteBoard = () => {
    axios.delete(`/api/boards/${boardNum}`)
    .then(res => alert(res.data === 0 ? '일치하는 글번호가 없습니다.' : '정상적으로 삭제되었습니다.'))
    .catch(error => console.log(error))
  }

  return(
    <div>
      <h2>게시글 삭제</h2>
      <div>
        <p>글번호</p>
        <input
         type="text"
         value={boardNum}
         onChange={e => setBoardData(e.target.value)} 
        />
        <button
         type="button"
         onClick={e => deleteBoard()}
        >삭제</button>
      </div>
    </div>
  )
}

export default DeleteForm