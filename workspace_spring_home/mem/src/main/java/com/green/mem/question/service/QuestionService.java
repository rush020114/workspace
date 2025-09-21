package com.green.mem.question.service;

import com.green.mem.question.dto.QuestionDTO;
import com.green.mem.question.dto.QuestionImgDTO;
import com.green.mem.question.mapper.QuestionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionService {
  public final QuestionMapper questionMapper;

  // 문의 등록과 이미지 등록
  @Transactional(rollbackFor = Exception.class)
  public void regQst(QuestionDTO questionDTO, List<QuestionImgDTO> questionImgDTOList){
    int nextQstId = questionMapper.getQstId();

    // 문의 등록
    questionMapper.regQst(questionDTO);

    // 이미지 등록
    if (questionImgDTOList.size() > 0) {
      for(QuestionImgDTO imgs : questionImgDTOList){
        imgs.setQstId(nextQstId);
      }
      questionMapper.regQuestionImgList(questionImgDTOList);
    }


  }

  // 이용자 문의 목록 조회
  public List<QuestionDTO> getQstList(QuestionDTO questionDTO){
    return questionMapper.getQstList(questionDTO);
  }

  // 문의 상세 조회 및 답변
  public QuestionDTO getQstDetail(QuestionDTO questionDTO){
    questionDTO.setImgCnt(questionMapper.getImgCnt(questionDTO.getQstId()));
    return questionMapper.getQstDetail(questionDTO);
  }


}
