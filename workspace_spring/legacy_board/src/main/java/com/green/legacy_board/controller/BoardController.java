package com.green.legacy_board.controller;

import com.green.legacy_board.dto.BoardDTO;
import com.green.legacy_board.dto.MemberDTO;
import com.green.legacy_board.service.BoardService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

  // 게시글 상세 페이지
  @GetMapping("/detail/{boardNum}")
  public String detail(@PathVariable("boardNum") int boardNum, Model model){
    // 보여질 html 파일명을 리턴
    System.out.println("전달받은 글번호 : " + boardNum);

    // 게시글 상세 조회
    model.addAttribute("boardDetail", boardService.getBoard(boardNum));

    // 게시글 상세페이지(board-detail.html)
    return "board-detail";
  }

  @GetMapping("/write-form")
  public String goWriteForm() {
    return "write-form";
  }

  @PostMapping("/write")
  public String write (@ModelAttribute BoardDTO boardDTO, HttpSession httpSession){
    Object loginData = httpSession.getAttribute("loginInfo");

    MemberDTO memberDTO = (MemberDTO)loginData;

    boardDTO.setWriter(memberDTO.getName());
    // 게시글 등록 쿼리 실행
    boardService.write(boardDTO);

    // 게시글 목록 페이지로 이동
    return "redirect:/boards";
  }
}
