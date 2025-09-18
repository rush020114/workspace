package com.green.mem.question.controller;

import com.green.mem.question.dto.QuestionDTO;
import com.green.mem.question.service.QuestionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/questions")
public class QuestionController {
  private final QuestionService questionService;

  // 문의 등록
  @PostMapping("")
  public void regQst(@RequestBody QuestionDTO questionDTO){
    log.info(questionDTO.toString());
    questionService.regQst(questionDTO);
  }

  // 이용자 문의 목록 조회
  @GetMapping("/{memId}")
  public List<QuestionDTO> getQstListForUser(@PathVariable("memId") String memId){
    return questionService.getQstListForUser(memId);
  }
}
