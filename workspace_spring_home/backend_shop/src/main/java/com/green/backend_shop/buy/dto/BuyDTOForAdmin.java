package com.green.backend_shop.buy.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
// 관리자 구매이력 조회를 받아오기 위한 dto
public class BuyDTOForAdmin {
  private int orderNum;
  private String memId;
  private int price;
  private LocalDateTime buyDate;
  private String title;

  public BuyDTOForAdmin(){
  }
}
