package com.green.mem.answer.service;

import com.green.mem.answer.dto.AnswerDTO;
import com.green.mem.answer.mapper.AnswerMapper;
import com.green.mem.question.mapper.QuestionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AnswerService {
  public final AnswerMapper answerMapper;
  public final QuestionMapper questionMapper;

  // 문의 답변 등록
  @Transactional(rollbackFor = Exception.class)
  public void regAnswer(AnswerDTO answerDTO){
    System.out.println(answerDTO.toString());
    // 중복 검사
    boolean result = answerMapper.getDupAnswer(answerDTO) == null;

    if(result){
      // 문의 답변 등록
      answerMapper.regAnswer(answerDTO);

      // 문의 답변 등록 시 문의 상태 바꾸기
      questionMapper.updateQstStatus(answerDTO);
    }
    else{
      // 중복 시 수정
      answerMapper.updateAnswer(answerDTO);
    }
  }

  // 답변 조회
  public AnswerDTO getAnswer(int qstId){
    return answerMapper.getAnswer(qstId);
  }
}
