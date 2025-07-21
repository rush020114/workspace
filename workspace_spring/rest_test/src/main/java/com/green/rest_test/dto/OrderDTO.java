package com.green.rest_test.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDTO {
  private int itemNum;
  private String itemName;
  private int itemPrice;
  private int itemCnt;
  private String buyerId;
  private int totalPrice;

  public OrderDTO(){
  }

  public OrderDTO(int itemNum, String itemName, int itemPrice, int itemCnt, String buyerId, int totalPrice){
    this.itemNum = itemNum;
    this.itemName = itemName;
    this.itemPrice = itemPrice;
    this.itemCnt = itemCnt;
    this.buyerId = buyerId;
    this.totalPrice = totalPrice;
  }

  public String toString(){
    return "상품번호: " + itemNum + ", 상품명: " + itemName + ", 가격: " + itemPrice + ", 수량: " + itemCnt + ", 주문자ID: " + buyerId + ", 총가격: " + totalPrice;
  }
}
