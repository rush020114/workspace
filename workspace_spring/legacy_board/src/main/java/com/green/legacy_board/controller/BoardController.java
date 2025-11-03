package com.green.legacy_board.controller;

import com.green.legacy_board.dto.BoardDTO;
import com.green.legacy_board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/boards")
public class BoardController {
  private final BoardService boardService;

  @GetMapping("")
  public String getBoardList(Model model){

    model.addAttribute("boardList", boardService.getBoardList());
    return "board-list";
  }

  @GetMapping("/detail")
  public String getBoardDetail(){
    // 보여질 html 파일명을 리턴
    return "board-detail";
  }

}
