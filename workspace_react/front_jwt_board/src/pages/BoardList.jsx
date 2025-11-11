import React, { useEffect, useState } from 'react'
import ListTable from '../components/ListTable'
import * as boardApi from '../apis/board/board_api'
import { useNavigate } from 'react-router-dom'

const BoardList = () => {
  const nav = useNavigate();

  // 게시글 목록을 저장할 state 변수
  const [boardList, setBoardList] = useState([]);

  useEffect(() => {
  const getBoardList = async () => {
    try {
      const result = await boardApi.getBoardListApi();
      setBoardList(result);
    } catch (error) {
      console.error('게시판 목록 불러오기 실패:', error);
    }
  };

  getBoardList();
}, []);

  
  console.log(boardList)
  return (
    <div>
      <div>
        <ListTable 
          cols={['제목', '작성자', '작성일', '조회수']}
          dataList={boardList}
          dataName={['title', 'writer', 'createDate', 'readCnt']}
          link="/board-detail"
          indexName="boardNum"
        />
      </div>
      <div>
        <button 
          type='button'
          onClick={() => nav('/write')}
        >
          글쓰기
        </button>
      </div>
      <div></div>
    </div>
  )
}

export default BoardList