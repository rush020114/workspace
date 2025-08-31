package com.green.backend_shop.cart.mapper;

import com.green.backend_shop.cart.dto.CartDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CartMapper {

  // 장바구니 목록 조회
  List<CartDTO> getCartList(String memId);

  // 장바구니 등록
  void insertCart (CartDTO cartDTO);

  // 장바구니 등록 시 중복 확인 중복이면 수정
  String getCartForDup(CartDTO cartDTO);

  // 중복 시 수정할 데이터
  void updateCart(CartDTO cartDTO);

  // 장바구니 삭제
  void deleteCart (int cartNum);

  // 장바구니 수량 수정
  void updateCartCnt(CartDTO cartDTO);
}
