package com.green.ExamPractice.controller;

import com.green.ExamPractice.dto.BoardDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BoardController {
  @GetMapping("/boards")
  public List<BoardDTO> getBoardList(){
    List<BoardDTO> boardDTOList = new ArrayList<>();
    boardDTOList.add(new BoardDTO(1, "제목1", "글쓴이1", "내용1", 1));
    boardDTOList.add(new BoardDTO(2, "제목2", "글쓴이2", "내용2", 5));
    boardDTOList.add(new BoardDTO(3, "제목3", "글쓴이3", "내용3", 2));
    boardDTOList.add(new BoardDTO(4, "제목4", "글쓴이4", "내용4", 3));
    boardDTOList.add(new BoardDTO(5, "제목5", "글쓴이5", "내용5", 10));
    return boardDTOList;
  }
}
