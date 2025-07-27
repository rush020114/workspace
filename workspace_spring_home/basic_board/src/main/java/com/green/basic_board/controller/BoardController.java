package com.green.basic_board.controller;

import com.green.basic_board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

// 객체생성 + controller역할
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
    boardService.insertBoard();
  }

  // 게시글을 수정하는 api
  @PutMapping("/boards")
  public void updateBoard(){
    boardService.updateBoard();
  }

  // 게시글을 삭제하는 api
  @DeleteMapping("/boards")
  public void deleteBoard(){
    boardService.deleteBoard();
  }
}
