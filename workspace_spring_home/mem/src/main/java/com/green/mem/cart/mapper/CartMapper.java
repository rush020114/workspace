package com.green.mem.cart.mapper;

import com.green.mem.cart.dto.CartDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CartMapper {

  // 장바구니 등록
  void insertCart(CartDTO cartDTO);

  // 장바구니 목록 조회
  List<CartDTO> getCartList (String memId);

  // 장바구니 중복 조회
  String getDupCart (CartDTO cartDTO);

  // 장바구니 등록 데이터 중복 시 장바구니 수정
  void updateCart (CartDTO cartDTO);
}
