import React, { useEffect, useState } from 'react'
import * as boardApi from '../apis/board/board_api'
import { useParams } from 'react-router-dom';

const BoardDetail = () => {
  const {boardNum} = useParams();

  // 게시글 상세정보를 저장할 state 변수
  const [boardDetail, setBoardDetail] = useState({});

  // 게시글 상세정보를 조회할 useEffect
  useEffect(() => {
    const getBoardDetail = async (num) => {
      const result = await boardApi.getBoardDetailApi(num);
      setBoardDetail(result);
    }
    getBoardDetail(boardNum);
  }, [boardNum]);
  console.log(boardDetail);

  return (
    <div>
      <div>글번호 : {boardDetail?.boardNum}</div>
      <div>제목 : {boardDetail?.title}</div>
      <div>내용 : {boardDetail?.content}</div>
      <div>작성자 : {boardDetail?.writer}</div>
      <div>작성일 : {boardDetail?.createDate}</div>
      <div>조회수 : {boardDetail?.readCnt}</div>
    </div>
  )
}

export default BoardDetail