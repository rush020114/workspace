package com.green.backend_student.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StuDTO {
  private int stuNum;
  private String stuName;
  private int stuAge;
  private int classNum;
  // 학생에 대해서 학급은 1:1관계이므로 classDTO 멤버변수를 선언
  private ClassDTO classDTO;

  public StuDTO(){
  }
}
