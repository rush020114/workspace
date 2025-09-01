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
  // 리액트에서 전달되는 cartNum 목록 데이터를 받기 위해 선언한 변수
  private List<Integer> cartNumList;

  public BuyDTO(){
  }
}
