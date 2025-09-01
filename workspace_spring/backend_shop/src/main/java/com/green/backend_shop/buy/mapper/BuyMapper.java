package com.green.backend_shop.buy.mapper;

import com.green.backend_shop.buy.dto.BuyDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BuyMapper {

  // 상세 페이지 물품 구매
  void insertDetailBuy (BuyDTO buyDTO);

  // 장바구니 물품 구매
  void buyAll (BuyDTO buyDTO);
}
