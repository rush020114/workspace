package com.green.mem.buy.mapper;

import com.green.mem.buy.dto.BuyDTO;
import com.green.mem.buy.dto.BuyDTOForAdmin;
import com.green.mem.buy.dto.SearchBuyDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BuyMapper {
  // 상세 페이지 구매
  void regBuyInDetail(BuyDTO buyDTO);

  // 장바구니 페이지 구매
  void regBuyInCart(BuyDTO buyDTO);

  // 구매 이력 조회
  List<BuyDTOForAdmin> getBuyListForAdmin(SearchBuyDTO searchBuyDTO);

  // 구매 이력 상세 조회
  List<BuyDTO> getBuyDetail(int orderNum);
}
