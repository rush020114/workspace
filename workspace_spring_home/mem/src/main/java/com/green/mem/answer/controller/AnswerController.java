package com.green.mem.answer.controller;

import com.green.mem.answer.dto.AnswerDTO;
import com.green.mem.answer.service.AnswerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/answers")
public class AnswerController {
  private final AnswerService answerService;

  // 문의 답변 등록
  @PostMapping("")
  public void regAnswer(@RequestBody AnswerDTO answerDTO){
    answerService.regAnswer(answerDTO);
  }

  // 답변 조회
  @GetMapping("/{qstId}")
  public AnswerDTO getAnswer(@PathVariable int qstId){
    return answerService.getAnswer(qstId);
  }
}
