package com.green.mem.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberDTO {
  private String memId;
  private String memPw;
  private String memName;
  private String memGender;
  private String memAddr;
  private String memTel;
  private String memIden;
  private String memEmail;

  public MemberDTO(){
  }
}
