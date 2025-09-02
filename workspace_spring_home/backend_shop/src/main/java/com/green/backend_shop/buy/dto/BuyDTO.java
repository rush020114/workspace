package com.green.backend_shop.buy.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
public class BuyDTO {
  private int buyNum;
  private int bookNum;
  private String memId;
  private LocalDateTime buyDate;
  private int buyCnt;
  // 장바구니 물품 구매를 위한 변수
  // 장바구니번호 배열을 받아 서브쿼리로 관련된 값들을 조회해 빈값을 채운다.
  // 장바구니 구매가 될 때 dto를 xml로 전달하므로 getter가 호출된다.
  private List<Integer> cartNumList;
  private int orderNum;

  public BuyDTO(){
  }
}
