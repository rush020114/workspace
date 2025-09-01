package com.green.backend_shop.buy.controller;

import com.green.backend_shop.buy.dto.BuyDTO;
import com.green.backend_shop.buy.service.BuyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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
}
