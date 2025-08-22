package com.green.backend_shop.cart.service;

import com.green.backend_shop.cart.dto.CartDTO;
import com.green.backend_shop.cart.mapper.CartMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {
  private final CartMapper cartMapper;

  // 장바구니 물품 등록
  public int insertCart(CartDTO cartDTO){
    return cartMapper.insertCart(cartDTO);
  }

  // 장바구니 목록 조회
  public List<CartDTO> getCartList(String memId){
    return cartMapper.getCartList(memId);
  }
}
