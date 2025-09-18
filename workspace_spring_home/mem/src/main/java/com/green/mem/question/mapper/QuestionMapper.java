package com.green.mem.question.mapper;

import com.green.mem.question.dto.QuestionDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QuestionMapper {
  // 문의 등록
  void regQst(QuestionDTO questionDTO);

  // 이용자 문의 목록 조회
  List<QuestionDTO> getQstListForUser(String memId);
}
