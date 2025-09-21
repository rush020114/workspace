package com.green.mem.answer.mapper;

import com.green.mem.answer.dto.AnswerDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AnswerMapper {
  // 문의 답변 등록
  void regAnswer(AnswerDTO answerDTO);

  // 답변 조회
  AnswerDTO getAnswer(int qstId);

  // 답변 중복 확인
  String getDupAnswer(AnswerDTO answerDTO);

  // 답변 중복 시 수정
  void updateAnswer(AnswerDTO answerDTO);
}
