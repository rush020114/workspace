import BoardList from "./BoardList"
import BoardDetail from "./BoardDetail"
import { useEffect, useState } from "react"
import axios from "axios";

const BoardInfo = () => {

  const [boardList, setBoardList] = useState([]);
  const [selectedBoard, setSelectedBoard] = useState({});
  const [isShow, setIsShow] = useState(false);

  useEffect(() => {
    axios.get('./api/boards')
    .then((res) => {
      console.log(res);
      setBoardList(res.data);
    })
    .catch((error) => console.log(error))
  }, [])

  return(
    <div className="info-container">
      <BoardList boardList={boardList} setSelectedBoard={setSelectedBoard} setIsShow={setIsShow} />
      {
        isShow
        ?
        <BoardDetail selectedBoard={selectedBoard} />
        :
        null
      }
    </div>
  )
}

export default BoardInfo