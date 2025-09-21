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

  public QuestionDTO(){
  }
}


