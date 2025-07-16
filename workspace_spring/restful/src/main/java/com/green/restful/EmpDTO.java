package com.green.restful;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpDTO {
  private String name;
  private String job;
  private int sal;

  public String toString(){
    return "이름 : " + name + ", 직급 : " + job + ", 급여 : " + sal;
  }
}
