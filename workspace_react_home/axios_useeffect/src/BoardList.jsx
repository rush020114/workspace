import './BoardList.css'

const BoardList = ({boardList, setSelectedBoard, setIsShow}) => {
  return(
    <div className="list-container">
      <h1>게시글 목록</h1>
      <table className="list-table">
        <colgroup>
          <col width='25%' />
          <col width='25%' />
          <col width='25%' />
          <col width='25%' />
        </colgroup>
        <thead>
          <tr>
            <td>글번호</td>
            <td>제목</td>
            <td>작성자</td>
            <td>조회수</td>
          </tr>
        </thead>
        <tbody>
          {
            boardList.map((board, i) => {
              return(
                <tr key={i}>
                  <td>{i}</td>
                  <td onClick={() => {
                    setSelectedBoard(board);
                    setIsShow(true);
                    }}>{board.title}</td>
                  <td>{board.writer}</td>
                  <td>{board.readCnt}</td>
                </tr>
              )
            })
          }
        </tbody>
      </table>
    </div>
  )
}

export default BoardList