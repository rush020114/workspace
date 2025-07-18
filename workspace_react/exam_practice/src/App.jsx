import { useEffect, useState } from "react"
import axios from "axios";
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import BoardList from './BoardList'
import BoardListDetail from './BoardListDetail'

function App() {
  const [boardList, setBoardList] = useState([]);
  const [selectedBoard, setSelectedBoard] = useState(null);

  useEffect(() => {
    axios.get('/api/boards')
    .then((res) => {
      console.log(res.data);
      setBoardList(res.data);
    })
    .catch((error) => console.log(error))
  }, [])

  console.log(selectedBoard)
  return (
    <>
      <BoardList
       boardList={boardList} 
       titleNum={selectedBoard} 
       setSelectedBoard={setSelectedBoard}/>
      <BoardListDetail boardList={boardList} selectedBoard={selectedBoard}/>
    </>
  )
}

export default App
