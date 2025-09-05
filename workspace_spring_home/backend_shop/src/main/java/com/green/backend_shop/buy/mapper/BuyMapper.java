package com.green.backend_shop.buy.mapper;

import com.green.backend_shop.buy.dto.BuyDTO;
import com.green.backend_shop.buy.dto.BuyDTOForAdmin;
import com.green.backend_shop.buy.dto.SearchBuyDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BuyMapper {
  // 도서 구매
  void buyBook (BuyDTO buyDTO);

  // 장바구니 도서 구매
  void buyCartBook(BuyDTO buyDTO);

  // 주문번호에 따른 관리자의 사용자 구매이력 조회
  List<BuyDTOForAdmin> getBuyListForAdmin(SearchBuyDTO searchBuyDTO);

  // 구매 내역 상세 조회
  List<BuyDTO> getBuyDetail(int orderNum);
}
