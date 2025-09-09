package com.green.backend_shop.buy.mapper;

import com.green.backend_shop.buy.dto.BuyDTO;
import com.green.backend_shop.buy.dto.BuyDTOForAdmin;
import com.green.backend_shop.buy.dto.SearchBuyDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BuyMapper {

  // 상세 페이지 물품 구매
  void insertDetailBuy (BuyDTO buyDTO);

  // 장바구니 물품 구매
  void buyAll (BuyDTO buyDTO);

  // 관리자 구매 이력 페이지의 구매목록조회
  List<BuyDTOForAdmin> getBuyListForAdmin(SearchBuyDTO searchBuyDTO);

  // 구매 상세 내역 조회
  List<BuyDTO> getDetailBuy(int orderNum);

  // 10일에 해당되는 날짜 조회
  List<String> get10Days();

  // 10일 간 매출
  List<Integer> getSales10Days();
}
