package com.green.backend_shop.cart.dto;

import com.green.backend_shop.book.dto.BookDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class CartDTO {
  private int cartNum;
  private int bookNum;
  private int cartCnt;
  private int totalPrice;
  private String memId;
  private LocalDateTime cartDate;
  // 장바구니 하나에는 책이 하나 들어감(관계 정리)
  private BookDTO bookDTO;

  public CartDTO(){
  }
}
