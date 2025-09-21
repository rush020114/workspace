package com.green.mem.question.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class QuestionImgDTO {
  private int imgNum;
  private String originImgName;
  private String attachedImgName;
  private int qstId;
  private String isMain;

  public QuestionImgDTO(){
  }

}
