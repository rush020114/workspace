import React from 'react'

const BoardListDetail = ({boardList, selectedBoard}) => {

  console.log(selectedBoard)
  console.log(boardList)
  return (
    <div className='boardList_container'>
      {
        boardList.map((e, i) => {
          return(
            selectedBoard === e
            ?
            <table>
              <colgroup>
                <col width='*'/>
                <col width='28%'/>
                <col width='28%'/>
                <col width='28%'/>
              </colgroup>
              <thead>
                <tr>
                  <td>제목</td>
                  <td colSpan={3}>{boardList[i].title}</td>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>작성자</td>
                  <td>{boardList[i].writer}</td>
                  <td>조회수</td>
                  <td>{boardList[i].boardCnt}</td>
                </tr>
                <tr>
                  <td>내용</td>
                  <td colSpan={3}>{boardList[i].content}</td>
                </tr>
              </tbody>
            </table>
            :
            null
          )
        })
      }
    </div>
  )
}

export default BoardListDetail
