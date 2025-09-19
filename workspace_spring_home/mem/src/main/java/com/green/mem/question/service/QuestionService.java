package com.green.mem.question.service;

import com.green.mem.question.dto.QuestionDTO;
import com.green.mem.question.mapper.QuestionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionService {
  public final QuestionMapper questionMapper;

  // 문의 등록
  public void regQst(QuestionDTO questionDTO){
    questionMapper.regQst(questionDTO);
  }

  // 이용자 문의 목록 조회
  public List<QuestionDTO> getQstList(QuestionDTO questionDTO){
    return questionMapper.getQstList(questionDTO);
  }

  // 문의 상세 조회 및 답변
  public QuestionDTO getQstDetail(QuestionDTO questionDTO){
    return questionMapper.getQstDetail(questionDTO);
  }
}
