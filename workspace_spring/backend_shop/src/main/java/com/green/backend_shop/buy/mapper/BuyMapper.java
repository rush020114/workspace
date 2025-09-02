package com.green.backend_shop.buy.mapper;

import com.green.backend_shop.buy.dto.BuyDTO;
import com.green.backend_shop.buy.dto.BuyDTOForAdmin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BuyMapper {

  // 상세 페이지 물품 구매
  void insertDetailBuy (BuyDTO buyDTO);

  // 장바구니 물품 구매
  void buyAll (BuyDTO buyDTO);

  // 관리자 구매 이력 페이지의 구매목록조회
  List<BuyDTOForAdmin> getBuyListForAdmin();
}
