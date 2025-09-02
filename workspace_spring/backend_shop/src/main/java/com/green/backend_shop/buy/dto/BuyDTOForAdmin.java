package com.green.backend_shop.buy.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

// 관리자의 구매이력 조회 페이지에서 조회한 구매 목록을 저장하기 위해 만든 dto 클래스
@Getter
@Setter
@ToString
public class BuyDTOForAdmin {
  private int orderNum;
  private String memId;
  private int price;
  private LocalDateTime buyDate;
  private String title;

  public BuyDTOForAdmin(){
  }
}
