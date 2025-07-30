import React from 'react'

const UpdateForm = ({nav, selectedBoard}) => {
  return (
    <div>
      <h1>게시글 수정 페이지</h1>
      <table>
        <tbody>
          <tr>
            <td>작성일</td>
            <td>{selectedBoard.createDate}</td>
            <td>작성자</td>
            <td></td>
          </tr>
        </tbody>
      </table>
    </div>
  )
}

export default UpdateForm