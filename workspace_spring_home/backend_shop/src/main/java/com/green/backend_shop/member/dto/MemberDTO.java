package com.green.backend_shop.member.dto;

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
  // 연락처를 받을 때는 배열로 받아야 하기에 배열 자료형을 쓰고
  // 조회할 때 property는 배열이 들어갈 수 없으므로 문자열 자료형을 쓴다.
  private String memTel;
  private String[] memTelArr;
  private String memAddr;
  private String addrDetail;
  private String memEmail;
  private String memRole;
  private LocalDateTime joinDate;

  public MemberDTO(){
  }
}
