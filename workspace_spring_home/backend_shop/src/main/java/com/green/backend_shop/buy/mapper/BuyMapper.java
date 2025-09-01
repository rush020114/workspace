package com.green.backend_shop.buy.mapper;

import com.green.backend_shop.buy.dto.BuyDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BuyMapper {
  // 도서 구매
  void buyBook (BuyDTO buyDTO);

  // 장바구니 도서 구매
  void buyCartBook(BuyDTO buyDTO);

}
