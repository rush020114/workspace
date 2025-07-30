package com.green.basic_board2.controller;

import com.green.basic_board2.dto.BoardDTO;
import com.green.basic_board2.service.BoardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boards") // 기본값 url을 제공하는 어노테이션
public class BoardController {
  private BoardService boardService;

  public BoardController(BoardService boardService){
    this.boardService = boardService;
  }

  // 게시글 등록 api
  @PostMapping("")
  public int insertBoard(@RequestBody BoardDTO boardDTO){
    System.out.println("게시글 등록 API 호출");
    System.out.println(boardDTO);
    return boardService.insertBoard(boardDTO);
  }

  // 게시글 수정 api
  @PutMapping("/{boardNum}")
  public int updateBoard(@RequestBody BoardDTO boardDTO, @PathVariable("boardNum") int boardNum){
    System.out.println(boardDTO);
    System.out.println(boardNum);
    boardDTO.setBoardNum(boardNum);
    return boardService.updateBoard(boardDTO);
  }

  // 게시글 삭제 api
  @DeleteMapping("/{boardNum}")
  public int deleteBoard(@PathVariable int boardNum){
    return boardService.deleteBoard(boardNum);
  }

  /*@GetMapping("")
  public List<BoardDTO> getBoardList(){
    return boardService.getBoardList();
  }*/

  @GetMapping("/{boardNum}")
  public BoardDTO getBoardListDetail(@PathVariable("boardNum") int boardNum){
    BoardDTO result = boardService.getBoardListDetail(boardNum);
    System.out.println(result);
    return result;
  }

  @GetMapping("/search/{title}")
  public List<BoardDTO> getBoardListTitle(@PathVariable("title") String title){
    List<BoardDTO> result = boardService.getBoardListTitle(title);
    System.out.println(result);
    return result;
  }
}
