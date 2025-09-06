package com.green.mem.buy.controller;

import com.green.mem.buy.dto.BuyDTO;
import com.green.mem.buy.service.BuyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/buys")
@RequiredArgsConstructor
public class BuyController {
  private final BuyService buyService;

  // 상세 페이지 구매 api
  @PostMapping("")
  public void regBuyInDetail(@RequestBody BuyDTO buyDTO){
    buyService.regBuyInDetail(buyDTO);
  }

  // 장바구니 페이지 구매
  @PostMapping("/cart-buy")
  public void regBuyInCart(@RequestBody BuyDTO buyDTO){
    buyService.regBuyInCart(buyDTO);
  }
}
