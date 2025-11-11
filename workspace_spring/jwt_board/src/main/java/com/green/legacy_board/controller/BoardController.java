package com.green.legacy_board.controller;

import com.green.legacy_board.dto.BoardDTO;
import com.green.legacy_board.dto.MemberDTO;
import com.green.legacy_board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/boards")
public class BoardController {
  private final BoardService boardService;

  @GetMapping("")
  public ResponseEntity<?> getBoardList(){
    // 게시글 목록 조회
    List<BoardDTO> boardDTOList = boardService.getBoardList();

    return ResponseEntity.status(HttpStatus.OK).body(boardDTOList);
  }

  // 게시글 등록
  @PostMapping("")
  public ResponseEntity<?> write (@RequestBody BoardDTO boardDTO){
    // 게시글 등록 쿼리 실행
    boardService.write(boardDTO);

    // 게시글 목록 페이지로 이동
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  // 게시글 삭제
  @GetMapping("/{boardNum}")
  public ResponseEntity<?> deleteBoard(@PathVariable("boardNum") int boardNum){
    boardService.deleteBoard(boardNum);
    return ResponseEntity.status(HttpStatus.OK).build();
  }

  // 게시글 수정
  @PutMapping("/{boardNum}")
  public ResponseEntity<?> updateBoard(
          @PathVariable("boardNum") int boardNum
          , @RequestBody BoardDTO boardDTO
  ){

    boardDTO.setBoardNum(boardNum);
    boardService.updateBoard(boardDTO);

    return ResponseEntity.status(HttpStatus.OK).build();
  }
}
