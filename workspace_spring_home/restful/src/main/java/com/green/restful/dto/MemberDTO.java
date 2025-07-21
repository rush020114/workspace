package com.green.restful.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDTO {
  private int memberNum;
  private String name;
  private int age;
  private String birth;

  public MemberDTO(){
  }

  public MemberDTO(int memberNum, String name, int age, String birth){
    this.memberNum = memberNum;
    this.name = name;
    this.age = age;
    this.birth = birth;
  }

  public String toString(){
    return "회원번호: " + memberNum + ", 이름: " + name + ", 나이: " + age + ", 생년월일: " + birth;
  }
}
