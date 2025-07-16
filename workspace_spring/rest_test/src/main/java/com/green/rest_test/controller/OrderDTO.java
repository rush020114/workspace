package com.green.rest_test.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDTO {
  private int itemNum;
  private String itemName;
  private int itemPrice;
  private int itemCnt;
  private String orderId;

  public String toString(){
    return "상품번호: " + itemNum + ", 상품명: " + itemName + ", 가격: " + itemPrice + ", 수량: " + itemCnt + ", 주문자ID: " + orderId;
  }
}
