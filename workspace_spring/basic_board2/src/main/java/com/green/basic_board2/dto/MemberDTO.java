package com.green.basic_board2.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class MemberDTO {
  private String memId;
  private String memPw;
  private String memName;
  private String memAge;

  public MemberDTO(){
  }

  public MemberDTO(String memId, String memPw, String memName, String memAge) {
    this.memId = memId;
    this.memPw = memPw;
    this.memName = memName;
    this.memAge = memAge;
  }
}
