import './BoardDetail.css'

const BoardDetail = ({selectedBoard}) => {
  return(
    <div className="detail-container">
      <h1>게시글{selectedBoard.boardNum}</h1>
      <table className="detail-table">
        <colgroup>
          <col width='*' />
          <col width='28%' />
          <col width='28%' />
          <col width='28%' />
        </colgroup>
        <thead>
          <tr>
            <td>제목</td>
            <td colSpan={3}>{selectedBoard.title}</td>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>작성자</td>
            <td>{selectedBoard.writer}</td>
            <td>조회수</td>
            <td>{selectedBoard.readCnt}</td>
          </tr>
          <tr>
            <td>내용</td>
            <td colSpan={3}>{selectedBoard.content}</td>
          </tr>
        </tbody>
      </table>
    </div>
  )
}

export default BoardDetail