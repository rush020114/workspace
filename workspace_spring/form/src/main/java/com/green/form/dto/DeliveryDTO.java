package com.green.form.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// DTO(Data Transfer Object) - 데이터를 전송할 때 사용하는 객체
@Getter
@Setter
public class DeliveryDTO {
  private String chicken;
  private int cnt;
  private String addr;
  private String detail;
  private String request;

  public DeliveryDTO(){
  }

  public DeliveryDTO(String chicken, int cnt, String addr, String detail, String request) {
    this.chicken = chicken;
    this.cnt = cnt;
    this.addr = addr;
    this.detail = detail;
    this.request = request;
  }

  public String toString(){
    return "치킨: " + chicken + ", 마리수: " + cnt + ", 주소: " + addr + ", 배달주소 상세: " + detail + ", 요청사항: " + request;
  }
}
