import React from 'react'

const BoardDetail = ({nav, selectedBoard}) => {
  return (
    <div>
      <h1>게시글 상세 정보 페이지</h1>
      <table>
        <tbody>
          <tr>
            <td>작성일</td>
            <td>{selectedBoard.createDate}</td>
            <td>작성자</td>
            <td>{selectedBoard.writer}</td>
            <td>조회수</td>
            <td>{selectedBoard.readCnt}</td>
          </tr>
          <tr>
            <td>제목</td>
            <td colSpan={5}>{selectedBoard.title}</td>
          </tr>
          <tr>
            <td>내용</td>
            <td colSpan={5}>{selectedBoard.content}</td>
          </tr>
        </tbody>
      </table>
      <div>
        <button
         type='button'
         onClick={e => nav(-1)}
        >목록가기</button>
        <button
         type='button'
         onClick={e => nav()}
        >수정</button>
        <button
         type='button'
         onClick={e => nav()}
        >삭제</button>
      </div>
    </div>
  )
}

export default BoardDetail