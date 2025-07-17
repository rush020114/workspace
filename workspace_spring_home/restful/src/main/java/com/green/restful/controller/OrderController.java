package com.green.restful.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderController {
  @GetMapping("orders")
  public List<Order> getOrderList(){
    List<Order> orderList = new ArrayList<>();
    orderList.add(new Order(101, "데님 청바지", 15000, 2, "abc"));
    orderList.add(new Order(102, "맨투맨 반팔 티셔츠", 10000, 3, "def"));
    orderList.add(new Order(103, "오버핏 니트", 25000, 2, "ghi"));
    orderList.add(new Order(104, "롱 패딩", 55000, 1, "jkl"));
    orderList.add(new Order(105, "맨투맨 긴팔 티셔츠", 12000, 3, "mno"));
    return orderList;
  }
}
