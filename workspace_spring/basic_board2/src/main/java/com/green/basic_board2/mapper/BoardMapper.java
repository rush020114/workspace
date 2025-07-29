package com.green.basic_board2.mapper;

import com.green.basic_board2.dto.BoardDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

// 쿼리의 빈 값은 메서드의 매개변수로 전달함
// 빈 값이 여러 개라도 매개변수로 하나의 데이터만 전달

// 메서드의 리턴타입
// insert, update, delete의 리턴타입 : int, void
// insert, update, delete 쿼리의 실행 결과는 쿼리의 영향을 받는 행의 개수
@Mapper
public interface BoardMapper {
  // 게시글 등록 쿼리 실행 추상메서드
  int insertBoard(BoardDTO boardDTO);

  // 게시글 수정 쿼리 실행 추상메서드
  int updateBoard(BoardDTO boardDTO);

  // 게시글 삭제 쿼리 실행 추상메서드
  int deleteBoard(int boardNum);

  List<BoardDTO> getBoardList();

  BoardDTO getBoardListDetail(int boardNum);

  List<BoardDTO> getBoardListTitle(String title);
}
