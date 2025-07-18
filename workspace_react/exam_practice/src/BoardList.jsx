import axios from "axios";
import './BoardList.css'
import { useEffect, useState } from "react"


const BoardList = ({boardList, selectedBoard, setSelectedBoard}) => {
  console.log(selectedBoard)

  return(
    <div className="boardList_container">
      <table className="table1">
        <thead className="thead1">
          <tr>
            <td>글번호</td>
            <td>제목</td>
            <td>작성자</td>
            <td>조회수</td>
          </tr>
        </thead>
        <tbody className="tbody1">
        {
          boardList.map((e, i) => {
            return(
              <tr key={i}>
                <td>{e.boardNum}</td>
                <td onClick={() => {setSelectedBoard(e)}}>{e.title}</td>
                <td>{e.writer}</td>
                <td>{e.boardCnt}</td>
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