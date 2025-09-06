package com.green.mem.buy.dto;

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
  private int clothingNum;
  private String memId;
  private LocalDateTime buyDate;
  private int buyCnt;
  private int orderNum;

  // 장바구니 번호들을 받을 list
  private List<Integer> cartNumList;

  public BuyDTO(){
  }
}
