package com.green.mem.cart.mapper;

import com.green.mem.cart.dto.CartDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CartMapper {

  // 장바구니 등록
  int insertCart(CartDTO cartDTO);
}
