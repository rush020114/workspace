package com.green.rest_test.controller;

import com.green.rest_test.dto.OrderDTO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderController {
  @GetMapping("/orders")
  public List<OrderDTO> getOrderList(){
    List<OrderDTO> orderDTOList = new ArrayList<>();
    orderDTOList.add(new OrderDTO(101, "데님 청바지", 15000, 2, "abc"));
    orderDTOList.add(new OrderDTO(102, "맨투맨 반팔 티셔츠", 10000, 3, "def"));
    orderDTOList.add(new OrderDTO(103, "오버핏 니트", 25000, 2, "ghi"));
    orderDTOList.add(new OrderDTO(104, "롱 패딩", 55000, 1, "jkl"));
    orderDTOList.add(new OrderDTO(105, "맨투맨 긴팔 티셔츠", 12000, 3, "mno"));
    return orderDTOList;
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
