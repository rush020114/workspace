package com.green.basic_board2.service;

import com.green.basic_board2.dto.BoardDTO;
import com.green.basic_board2.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
  private BoardMapper boardMapper;

  public BoardService(BoardMapper boardMapper){
    this.boardMapper = boardMapper;
  }

  // 게시글 등록 메서드
  public int insertBoard(BoardDTO boardDTO){
    System.out.println("게시글 등록을 시작합니다.");
    System.out.println("등록 완료!");
    // update 쿼리 실행 결과 영향을 받은 행의 개수
    return boardMapper.insertBoard(boardDTO);
  }

  // 게시글 수정 메서드
  public int updateBoard(BoardDTO boardDTO){
    return boardMapper.updateBoard(boardDTO);
  }

  // 게시글 삭제 메서드
  public int deleteBoard(int boardNum){
    return boardMapper.deleteBoard(boardNum);
  }

  public List<BoardDTO> getBoardList(){
    return boardMapper.getBoardList();
  }

  public BoardDTO getBoardListDetail(int boardNum){
    return boardMapper.getBoardListDetail(boardNum);
  }

  public List<BoardDTO> getBoardListTitle(String title){
    return boardMapper.getBoardListTitle(title);
  }
}
