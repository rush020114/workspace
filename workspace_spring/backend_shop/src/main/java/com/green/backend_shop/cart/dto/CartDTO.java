package com.green.backend_shop.cart.dto;

import com.green.backend_shop.book.dto.BookDTO;
import com.green.backend_shop.book.dto.BookImgDTO;
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
  private String memId;
  private int totalPrice;
  private LocalDateTime cartDate;
  // 장바구니 하나에는 책이 하나 들어가 있다.
  // 1 : 1의 관계 형성
  private BookDTO bookDTO;

  public CartDTO(){
  }
}
