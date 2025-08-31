package com.green.mem.cart.service;

import com.green.mem.cart.dto.CartDTO;
import com.green.mem.cart.mapper.CartMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {
  private final CartMapper cartMapper;

  // 장바구니 등록
  public void insertCart(CartDTO cartDTO){
    boolean result = cartMapper.getDupCart(cartDTO) == null;
    if(result){
      cartMapper.insertCart(cartDTO);
    }
    else{
      cartMapper.updateCart(cartDTO);
    }
  }

  // 장바구니 목록 조회
  public List<CartDTO> getCartList(String memId){
    return cartMapper.getCartList(memId);
  }

  // 장바구니 삭제
  public void deleteCart (int cartNum){
    cartMapper.deleteCart(cartNum);
  }

  // 장바구니 수량 수정
  public void updateCartCnt(CartDTO cartDTO){
    cartMapper.updateCartCnt(cartDTO);
  }
}
