package com.green.mem.cart.dto;

import com.green.mem.clothing.dto.ClothingDTO;
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
  private ClothingDTO clothingDTO;
  
  public CartDTO(){
  }
}
