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
  // 학생은 한 학급을 가지고 있다.
  // 학생 기준으로 조회를 할 것이기 때문에
  // 한 학생 당 한 학급을 가지고 있음을 학생DTO에
  // 학급DTO를 넣어서 표현했다.
  private ClassDTO classDTO;

  public StuDTO(){
  }
}
