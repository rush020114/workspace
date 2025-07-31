package com.green.db_board.controller;

import com.green.db_board.dto.BoardDTO;
import com.green.db_board.service.BoardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boards")
public class BoardController {
  private BoardService boardService;

  public BoardController(BoardService boardService){
    this.boardService = boardService;
  }

  @GetMapping("")
  public List<BoardDTO> getBoardList(){
    return boardService.getBoardList();
  }

  @GetMapping("/{boardNum}")
  public BoardDTO getBoard(@PathVariable("boardNum") int boardNum){
    //조회수 1증가 쿼리
    return boardService.getBoard(boardNum);
  }

  @PostMapping("")
  public int insertBoard(@RequestBody BoardDTO boardDTO){
    return boardService.insertBoard(boardDTO);
  }

  @PutMapping("/{boardNum}")
  public int updateBoard(@RequestBody BoardDTO boardDTO, @PathVariable("boardNum") int boardNum){
    boardDTO.setBoardNum(boardNum);
    return boardService.updateBoard(boardDTO);
  }

  @PutMapping("/read-cnt/{boardNum}")
  public int updateReadCnt(@PathVariable int boardNum){
    return boardService.updateReadCnt(boardNum);
  }

  @DeleteMapping("/{boardNum}")
  public int deleteBoard(@PathVariable("boardNum") int boardNum){
    return boardService.deleteBoard(boardNum);
  }
}
