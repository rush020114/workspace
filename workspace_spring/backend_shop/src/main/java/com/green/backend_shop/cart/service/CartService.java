package com.green.backend_shop.cart.service;

import com.green.backend_shop.buy.dto.BuyDTO;
import com.green.backend_shop.buy.dto.BuyDTOForAdmin;
import com.green.backend_shop.buy.mapper.BuyMapper;
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
  // 쿼리가 다수여도 기능이 하나뿐이면 service에는 하나의 메서드(기능)여도 충분하다.
  // 현재 장바구니에 등록할 존재하면 수량을 업데이트, 존재하지 않으면 등록
  public void insertCart(CartDTO cartDTO){
    // 현재 선택한 상품이 장바구니에 있는지 확인
    String result = cartMapper.getCartNum(cartDTO);

    // 현재 내 장바구니에 없는 상품이면 장바구니에 등록
    if(result == null){
      cartMapper.insertCart(cartDTO);
    }
    // 현재 내 장바구니에 있는 상품이면 장바구니의 수량을 업데이트
    else{
      cartMapper.updateCartCnt(cartDTO);
    }
  }

  // 장바구니 목록 조회
  public List<CartDTO> getCartList(String memId){
    return cartMapper.getCartList(memId);
  }

  // 장바구니 삭제
  public int deleteCart(int cartNum){
    return cartMapper.deleteCart(cartNum);
  }

  // 장바구니 페이지 수량 변경
  public void updateCart(CartDTO cartDTO){
    cartMapper.updateCart(cartDTO);
  }

}
