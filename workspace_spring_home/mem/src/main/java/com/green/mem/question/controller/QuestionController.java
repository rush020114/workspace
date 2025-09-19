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
  @GetMapping("")
  public List<QuestionDTO> getQstList(QuestionDTO questionDTO){
    return questionService.getQstList(questionDTO);
  }

  // 문의 상세 조회 및 답변
  @GetMapping("/detail")
  public QuestionDTO getQstDetail(QuestionDTO questionDTO){
    log.info(questionDTO.toString());
    return questionService.getQstDetail(questionDTO);
  }
}
