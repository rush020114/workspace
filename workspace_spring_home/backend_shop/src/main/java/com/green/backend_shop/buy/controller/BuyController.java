package com.green.backend_shop.buy.controller;

import com.green.backend_shop.buy.dto.BuyDTO;
import com.green.backend_shop.buy.dto.BuyDTOForAdmin;
import com.green.backend_shop.buy.service.BuyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/buys")
@RequiredArgsConstructor
public class BuyController {
  private final BuyService buyService;

  // 도서 구매 api
  @PostMapping("")
  public void buyBook (@RequestBody BuyDTO buyDTO){
    buyService.buyBook(buyDTO);
  }

  // 장바구니 도서 구매 api
  @PostMapping("/carts")
  public void buyCartBook(@RequestBody BuyDTO buyDTO){
    buyService.buyCartBook(buyDTO);
  }

  // 주문번호에 따른 관리자의 사용자 구매이력 조회 api
  @GetMapping("buy-list-admin")
  public List<BuyDTOForAdmin> getBuyListForAdmin(){
    return buyService.getBuyListForAdmin();
  }
}
