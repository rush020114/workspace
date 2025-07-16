package com.green.rest_test.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {
  @GetMapping("/orders")
  public String getOrderList(){
    return "모든 주문정보 조회 완료";
  }

  @GetMapping("/orders/{itemNum}")
  public String getOrder(@PathVariable("itemNum") int itemNum){
    System.out.println(itemNum);
    return "하나의 주문정보 조회 완료";
  }

  @PostMapping("/orders")
  public String insertOrder(@RequestBody OrderDTO orderDTO){
    System.out.println(orderDTO);
    return "하나의 주문정보 등록 완료";
  }

  @DeleteMapping("/orders/{itemNum}")
  public String deleteOrder(@PathVariable("itemNum") int itemNum){
    System.out.println(itemNum);
    return "하나의 주문정보 삭제 완료";
  }

  @PutMapping("/orders/{itemNum}")
  public String updateOrder(@RequestBody OrderDTO orderDTO, @PathVariable("itemNum") int itemNum){
    System.out.println(orderDTO);
    System.out.println(itemNum);
    return "하나의 주문정보에서 상품명과 상품가격을 수정 완료";
  }
}
