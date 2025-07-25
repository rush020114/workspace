package com.green.basic_board.mapper;

import org.apache.ibatis.annotations.Mapper;

// 쿼리문을 실행할 추상메서드를 작성
// 추상메서드명은 반드시 실행할 쿼리의 id와 일치를 시켜야 한다.
@Mapper // 객체생성 + 해당 인터페이스의 쿼리를 실행할 메서드가 있음을 인지시켜주는 역할
public interface BoardMapper {
  // 모든 게시글을 조회하는 쿼리를 실행하는 메서드
  void getBoardList();

  // 하나의 게시글의 모든 정보를 조회하는 쿼리를 실행하는 추상메서드
  void getBoard();

  // 게시글 등록 쿼리를 실행하는 추상메서드
  void insertBoard();

  // 게시글 삭제 쿼리를 실행하는 추상메서드
  void deleteBoard();

  // 게시글 수정 쿼리를 실행하는 추상메서드
  void updateBoard();
}
