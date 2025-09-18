package com.green.mem.question.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

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

  public QuestionDTO(){
  }
}


