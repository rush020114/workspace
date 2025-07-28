package com.green.basic_board2.controller;

import com.green.basic_board2.dto.BoardDTO;
import com.green.basic_board2.service.BoardService;
import org.springframework.web.bind.annotation.*;

@RestController
public class BoardController {
  private BoardService boardService;

  public BoardController(BoardService boardService){
    this.boardService = boardService;
  }

  // 게시글 등록 api
  @PostMapping("/boards")
  public int insertBoard(@RequestBody BoardDTO boardDTO){
    System.out.println("게시글 등록 API 호출");
    System.out.println(boardDTO);
    return boardService.insertBoard(boardDTO);
  }

  // 게시글 수정 api
  @PutMapping("/boards/{boardNum}")
  public int updateBoard(@RequestBody BoardDTO boardDTO, @PathVariable("boardNum") int boardNum){
    System.out.println(boardDTO);
    System.out.println(boardNum);
    boardDTO.setBoardNum(boardNum);
    return boardService.updateBoard(boardDTO);
  }

  // 게시글 삭제 api
  @DeleteMapping("/boards/{boardNum}")
  public int deleteBoard(@PathVariable int boardNum){
    return boardService.deleteBoard(boardNum);
  }
}
