package com.green.basic_board.service;

import com.green.basic_board.dto.BoardDTO;
import com.green.basic_board.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// 핵심기능이 만들어져 있는 클래스에 service를 붙인다.
// 핵심기능(쿼리 작업)을 제공하는 메서드 구현!
// 인터페이스 객체를 사용하는 개념이 약간 다름.
// 일단 인터페이스에서 Mapper 어노테이션으로 인해 자동으로 만들어진 객체를
// 생성자 주입으로 받아 사용한다.
@Service // 객체 생성 + 비즈니스 로직이 포함된 클래스임을 알림
public class BoardService {
  private BoardMapper boardMapper;

  // 생성자를 이용한 의존성 주입
  @Autowired
  public BoardService(BoardMapper boardMapper){
    this.boardMapper = boardMapper;
  }

  // 모든 게시글을 조회하는 기능
  public List<BoardDTO> getBoardList(){
    return boardMapper.getBoardList();
  }

  // 하나의 게시글을 조회하는 기능
  public BoardDTO getBoard(int boardNum){
    return boardMapper.getBoard(boardNum);
  }

  public List<BoardDTO> getBoardToName(String title){
    return boardMapper.getBoardToName(title);
  }

  // 하나의 게시글을 등록하는 기능
  public int insertBoard(BoardDTO boardDTO){
    return boardMapper.insertBoard(boardDTO);
  }

  // 하나의 게시글을 조회하는 기능
  public int updateBoard(BoardDTO boardDTO){
    return boardMapper.updateBoard(boardDTO);
  }

  // 하나의 게시글을 삭제하는 기능
  public int deleteBoard(int boardNum){
    return boardMapper.deleteBoard(boardNum);
  }
}
