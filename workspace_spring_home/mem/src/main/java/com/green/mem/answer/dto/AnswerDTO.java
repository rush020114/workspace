package com.green.mem.answer.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class AnswerDTO {
  private int ansId;
  private String ansContent;
  private String qstId;
  private String memId;
  private LocalDateTime ansDate;

  public AnswerDTO(){
  }
}
