package com.green.legacy_board.service;

import com.green.legacy_board.dto.BoardDTO;
import com.green.legacy_board.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
  private final BoardMapper boardMapper;

  public List<BoardDTO> getBoardList(){
    return boardMapper.getBoardList();
  }

  public void write(BoardDTO boardDTO){
    boardMapper.write(boardDTO);
  }

  // 게시글 상세 조회
  public BoardDTO getBoard(int boardNum){
    return boardMapper.getBoard(boardNum);
  }

  // 게시글 삭제
  public void deleteBoard(int boardNum){
    boardMapper.deleteBoard(boardNum);
  }

  // 게시글 수정
  public void updateBoard(BoardDTO boardDTO){
    boardMapper.updateBoard(boardDTO);
  }
}
