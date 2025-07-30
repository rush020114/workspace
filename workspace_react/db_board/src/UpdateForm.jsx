import React, { useState } from 'react'

const UpdateForm = () => {

  const [updateBoardData, setUpdateBoardData] = useState({
    boardNum: ''
    , title: ''
    , content: ''
  })

  return (
    <div>
      <h1>게시글 수정 페이지</h1>
      <table>
        <tbody>
          <tr>
            <td>작성일</td>
            <td></td>
            <td>작성자</td>
            <td></td>
          </tr>
          <tr>
            <td>제목</td>
            <td colSpan={3}></td>
          </tr>
          <tr>
            <td>내용</td>
            <td colSpan={3}></td>
          </tr>
        </tbody>
      </table>
    </div>
  )
}

export default UpdateForm