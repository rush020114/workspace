package com.green.basic_board.controller;

import com.green.basic_board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// 객체 생성 + controller 역할을 부여
@RestController
public class BoardController {
  private BoardService boardService;

  @Autowired
  public BoardController(BoardService boardService){
    this.boardService = boardService;
  }

  // 게시글을 등록하는 api
  @PostMapping("/boards")
  public void insertBoard(){
    boardService.regBoard();
  }

  // 게시글을 삭제하는 api
  @DeleteMapping("/boards")
  public void deleteBoard(){
    boardService.removeBoard();
  }

  // 게시글을 등록하는 api
  @PutMapping("/boards")
  public void updateBoard(){
    boardService.updateBoard();
  }
}





