import React, { useState } from 'react'
import { regBoardApi } from '../apis/board/board_api';
import { useNavigate } from 'react-router-dom';

const BoardWrite = () => {
  const nav = useNavigate();
  
  // 등록할 게시글 정보를 저장할 state 변수
  const [boardInfo, setBoardInfo] = useState({
    title: ''
    , content: ''
  });

  // 게시글을 입력할 수 있는 함수
  const handleBoardInfo = e => {
    setBoardInfo({
      ...boardInfo
      , [e.target.name]: e.target.value
    })
  };

  // 게시글 등록 함수
  const regBoard = async boardData => {
    await regBoardApi(boardData);
    nav('/');
  }
  
  return (
    <div>
      제목 : 
      <input type="text" 
        name='title'
        value={boardInfo.title}
        onChange={e => handleBoardInfo(e)}
      /> <br />
      내용 : 
      <textarea 
        name='content'
        value={boardInfo.content}
        onChange={e => handleBoardInfo(e)}
        cols={50} 
        rows={5}
      ></textarea> <br />
      <button 
        type='button'
        onClick={() => regBoard(boardInfo)}
      >등록</button>
    </div>
  )
}

export default BoardWrite