package com.green.restful.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {
  private int itemNum;
  private String itemName;
  private int itemPrice;
  private int itemCnt;
  private String buyerId;

  public Order(){
  }

  public Order(int itemNum, String itemName, int itemPrice, int itemCnt, String buyerId){
    this.itemNum = itemNum;
    this.itemName = itemName;
    this.itemPrice = itemPrice;
    this.itemCnt = itemCnt;
    this.buyerId = buyerId;
  }
}
