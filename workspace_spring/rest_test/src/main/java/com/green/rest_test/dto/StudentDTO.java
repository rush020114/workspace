package com.green.rest_test.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDTO {
  private String name;
  private int korScore;
  private int engScore;
  private String addr;

  public StudentDTO(){
  }

  public StudentDTO(String name, int korScore, int engScore, String addr){
    this.name = name;
    this.korScore = korScore;
    this.engScore = engScore;
    this.addr = addr;
  }

  public String toString(){
    return "이름: " + name + ", 국어점수: " + korScore + ", 영어점수: " + engScore + ", 주소: " + addr;
  }
}
