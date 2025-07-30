package com.green.db_board.mapper;

import com.green.db_board.dto.BoardDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
  List<BoardDTO> getBoardList();

  BoardDTO getBoard(int boardNum);

  int insertBoard(BoardDTO boardDTO);

  int updateBoard(BoardDTO boardDTO);
}
