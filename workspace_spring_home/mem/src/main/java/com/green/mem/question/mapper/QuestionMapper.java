package com.green.mem.question.mapper;

import com.green.mem.answer.dto.AnswerDTO;
import com.green.mem.question.dto.QuestionDTO;
import com.green.mem.question.dto.QuestionImgDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QuestionMapper {
  // 문의 등록
  void regQst(QuestionDTO questionDTO);

  // 이용자 문의 목록 조회
  List<QuestionDTO> getQstList(QuestionDTO questionDTO);

  // 문의 상세 조회 및 답변
  QuestionDTO getQstDetail(QuestionDTO questionDTO);

  // 문의 번호 조회
  int getQstId();

  // 문의 이미지 등록
  void regQuestionImgList(List<QuestionImgDTO> questionImgDTOList);

  // 답변 등록 시 문의 상태 바꾸기
  void updateQstStatus(AnswerDTO answerDTO);

  // 문의 테이블 등록 시 사진 등록 안 할 때 문의 테이블 조인 조회 시 사진 테이블을 조회하지 않게 하는 메서드
  int getImgCnt(int qstId);
}
