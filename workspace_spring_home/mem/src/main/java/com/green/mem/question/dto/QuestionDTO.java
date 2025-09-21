package com.green.mem.question.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
public class QuestionDTO {
  private int qstId;
  private String qstTitle;
  private String qstContent;
  private String memId;
  private LocalDateTime qstDate;
  private String qstStatus;
  private String memRole;
  private List<QuestionImgDTO> questionImgDTOList;

  // 문의 테이블 등록 시 사진 등록 안 할 때 문의 테이블 조인 조회 시 사진 테이블을 조회하지 않게 하는 변수
  private int imgCnt;

  public QuestionDTO(){
  }
}


