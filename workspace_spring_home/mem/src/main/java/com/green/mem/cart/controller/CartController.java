package com.green.mem.cart.controller;

import com.green.mem.cart.dto.CartDTO;
import com.green.mem.cart.service.CartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("carts")
@RequiredArgsConstructor
public class CartController {
  private final CartService cartService;

  // 장바구니 등록 api
  @PostMapping("")
  public int insertCart(@RequestBody CartDTO cartDTO){
    return cartService.insertCart(cartDTO);
  }
}
