package com.green.db_board.service;

import com.green.db_board.dto.BoardDTO;
import com.green.db_board.mapper.BoardMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
  private BoardMapper boardMapper;

  public BoardService(BoardMapper boardMapper){
    this.boardMapper = boardMapper;
  }

  public List<BoardDTO> getBoardList(){
    return boardMapper.getBoardList();
  }

  public BoardDTO getBoard(int boardNum){
    return boardMapper.getBoard(boardNum);
  }

  public int insertBoard(BoardDTO boardDTO){
    return boardMapper.insertBoard(boardDTO);
  }

  public int updateBoard(BoardDTO boardDTO){
    return boardMapper.updateBoard(boardDTO);
  }

  public int updateReadCnt(int boardNum){
    return boardMapper.updateReadCnt(boardNum);
  }

  public int deleteBoard(int boardNum){
    return boardMapper.deleteBoard(boardNum);
  }
}
