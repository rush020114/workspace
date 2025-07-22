package com.green.rest_test.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberDTO {
  private String id;
  private String pw;
  private String checkPw;
  private String emailAddr;
  private String name;
  private String idenNum1;
  private String idenNum2;
  private String year;
  private String month;
  private String day;
  private String addr;
  private String addr1;
  private String addr2;
  private String introduce;

  public MemberDTO(){
  }

  public MemberDTO(String id, String pw, String checkPw, String emailAddr, String name, String idenNum1, String idenNum2, String year, String month, String day, String addr, String addr1, String addr2, String introduce) {
    this.id = id;
    this.pw = pw;
    this.checkPw = checkPw;
    this.emailAddr = emailAddr;
    this.name = name;
    this.idenNum1 = idenNum1;
    this.idenNum2 = idenNum2;
    this.year = year;
    this.month = month;
    this.day = day;
    this.addr = addr;
    this.addr1 = addr1;
    this.addr2 = addr2;
    this.introduce = introduce;
  }
}
