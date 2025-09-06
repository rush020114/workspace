package com.green.mem.buy.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class BuyDTOForAdmin {
  private int buyNum;
  private int orderNum;
  private String clothingName;
  private String memId;
  private int totalPrice;
  private LocalDateTime buyDate;

  public BuyDTOForAdmin(){
  }
}
