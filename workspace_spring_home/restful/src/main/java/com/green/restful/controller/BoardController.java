package com.green.restful.controller;

import com.green.restful.dto.BoardDTO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

// REST : 상태를 나타내는 url 작성 규칙
// REST를 따르면 url의 명명이 훨씬 간결해진다.
// 다른 시스템으로부터 데이터를 받기 위한 상호작용 방법으로 API를 구현해야 한다.
// RESTful API : REST를 다 구현한 프로젝트(RESTful)로 데이터를 주고받는 것
// 이를 위해 클라이언트로부터 요청을 받았을 때 그 요청에 대한 기능을 잘 실행시켜줄 컨트롤러(RestController)를 만든다.
@RestController
public class BoardController {
  // 이후 get(조회), post(삽입), put(수정), delete(삭제)에 대한 어노테이션을 생성해 요청을 받아올 수 있다.
  // 이를 모두 사용하면 스프링에 대한 API 코드 구현을 마칠 수 있다.
  @GetMapping("/boards") // 조회를 위한 어노테이션
  public List<BoardDTO> getBoardList(){
    List<BoardDTO> boardDTOList = new ArrayList<>();
    boardDTOList.add(new BoardDTO(1, "제목1", "김", "내용1", 1));
    boardDTOList.add(new BoardDTO(2, "제목2", "이", "내용2", 5));
    boardDTOList.add(new BoardDTO(3, "제목3", "박", "내용3", 2));
    boardDTOList.add(new BoardDTO(4, "제목4", "최", "내용4", 3));
    boardDTOList.add(new BoardDTO(5, "제목5", "정", "내용5", 10));
    return boardDTOList;
  }

  @GetMapping("/boards/{boardNum}") // url로 변수를 받아 url에서 원하는 주소를 입력해도 받을 수 있게 되었다.
  public String getBoard(@PathVariable("boardNum") int boardNum){ // PathVariable 어노테이션을 통해 url로 넘어오는 데이터를 받을 수 있다.
    System.out.println(boardNum);
    return "게시판 목록 한 개 조회 완료";
  }

  @PostMapping("/boards") // 등록을 위한 어노테이션
  public String insertBoard(@RequestBody BoardDTO boardDTO){ // RequestBody 어노테이션으로 클라이언트가 요청 시 전달되는 객체를 받을 수 있다.
    System.out.println(boardDTO);
    return "게시판 등록 완료";
  }

  @DeleteMapping("/boards/{boardNum}") // 삭제를 위헌 어노테이션
  public String deleteBoard(@PathVariable("boardNum") int boardNum){
    System.out.println(boardNum);
    return "게시판 한 개 삭제 완료";
  }

  @PutMapping("/boards/{boardNum}") // 수정을 위한 어노테이션
  public String updateBoard(@RequestBody BoardDTO boardDTO, @PathVariable("boardNum") int boardNum){
    System.out.println(boardDTO);
    System.out.println(boardNum);
    return "게시판 한 개 수정 완료";
  }
}
