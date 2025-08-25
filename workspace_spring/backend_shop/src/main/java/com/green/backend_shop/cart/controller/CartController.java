package com.green.backend_shop.cart.controller;

import com.green.backend_shop.cart.dto.CartDTO;
import com.green.backend_shop.cart.service.CartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/carts")
public class CartController {
  private final CartService cartService;

  // 장바구니 물품 등록
  @PostMapping("")
  public void insertCart(@RequestBody CartDTO cartDTO){
    cartService.insertCart(cartDTO);
  }

  // 장바구니 목록 조회
  @GetMapping("/{memId}")
  public List<CartDTO> getCartList(@PathVariable("memId") String memId){
    return cartService.getCartList(memId);
  }
}
