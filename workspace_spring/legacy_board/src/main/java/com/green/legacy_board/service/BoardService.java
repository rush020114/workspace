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
}
