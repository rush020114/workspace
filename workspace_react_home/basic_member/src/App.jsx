import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import SignUp from './SignUp'
import InsertBoard from './InsertBoard'
import UpdateBoard from './UpdateBoard'
import DeleteBoard from './DeleteBoard'
import BoardList from './BoardList'
import BoardDetail from './BoardDetail'
import SearchBoardList from './SearchBoardList'

function App() {

  return (
    <>
      {/* <SignUp /> */}
      {/* <InsertBoard /> */}
      {/* <UpdateBoard /> */}
      {/* <DeleteBoard /> */}
      {/* <BoardList /> */}
      <BoardDetail />
      {/* <SearchBoardList /> */}
    </>
  )
}

export default App
