package com.green.mem.cart.mapper;

import com.green.mem.cart.dto.CartDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CartMapper {

  // 장바구니 등록
  int insertCart(CartDTO cartDTO);

  // 장바구니 목록 조회
  List<CartDTO> getCartList (String memId);
}
