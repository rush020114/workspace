package com.green.basic_board.controller;

import com.green.basic_board.dto.BoardDTO;
import com.green.basic_board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 객체생성 + controller역할
@RestController
@RequestMapping("/boards")
public class BoardController {
  private BoardService boardService;

  @Autowired
  public BoardController(BoardService boardService){
    this.boardService = boardService;
  }

  // 게시글을 등록하는 api
  @PostMapping("")
  public int insertBoard(@RequestBody BoardDTO boardDTO){
    return boardService.insertBoard(boardDTO);
  }

  // 게시글을 수정하는 api
  @PutMapping("/{boardNum}")
  public int updateBoard(@PathVariable("boardNum") int boardNum, @RequestBody BoardDTO boardDTO){
    boardDTO.setBoardNum(boardNum);
    return boardService.updateBoard(boardDTO);
  }

  // 게시글을 삭제하는 api
  @DeleteMapping("/{boardNum}")
  public int deleteBoard(@PathVariable("boardNum") int boardNum){
    return boardService.deleteBoard(boardNum);
  }

  @GetMapping("")
  public List<BoardDTO> getBoardList(){
    return boardService.getBoardList();
  }

  @GetMapping("/{boardNum}")
  public BoardDTO getBoard(@PathVariable("boardNum") int boardNum){
    return boardService.getBoard(boardNum);
  }

  /*@GetMapping("/{title}")
  public List<BoardDTO> getBoardToName(@PathVariable("title") String title){
    return boardService.getBoardToName(title);
  }*/
}
