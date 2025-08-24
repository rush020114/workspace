package com.green.mem.cart.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class CartDTO {
  private int cartNum;
  private int clothingNum;
  private int cartCnt;
  private int totalPrice;
  private LocalDateTime cartDate;
  private String memId;
  
  public CartDTO(){
  }
}
