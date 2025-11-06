package com.green.legacy_board.mapper;

import com.green.legacy_board.dto.BoardDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
  List<BoardDTO> getBoardList();

  void write(BoardDTO boardDTO);

  // 게시글 상세 조회
  BoardDTO getBoard(int boardNum);
}
