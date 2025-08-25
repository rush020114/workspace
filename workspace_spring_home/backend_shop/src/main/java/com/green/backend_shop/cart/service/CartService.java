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

  // 장바구니 목록 조회
  public List<CartDTO> getCartList(String memId){
    return cartMapper.getCartList(memId);
  }

  // 장바구니 등록
  // 등록을 위한 쿼리는 3개이지만 핵심기능을 구현하는 service에서
  // 쿼리 3개를 실행하기 위해서는 기능은 하나이먄 충분하다 판단되면
  // 기능(메서드)를 하나로만 만들어도 충분하다.
  public void insertCart(CartDTO cartDTO){
    // 장바구니 조회 시 조회가 되지 않으면 등록
    if(cartMapper.getCartForDup(cartDTO) == null){
      cartMapper.insertCart(cartDTO);
    }
    // 조회가 되면 수정
    else{
      cartMapper.updateCart(cartDTO);
    }
  }
}
