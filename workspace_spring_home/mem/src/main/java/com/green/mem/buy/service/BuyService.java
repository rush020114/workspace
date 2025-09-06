package com.green.mem.buy.service;

import com.green.mem.buy.dto.BuyDTO;
import com.green.mem.buy.dto.BuyDTOForAdmin;
import com.green.mem.buy.mapper.BuyMapper;
import com.green.mem.cart.mapper.CartMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BuyService {
  private final BuyMapper buyMapper;
  private final CartMapper cartMapper;

  // 상세 페이지 구매
  public void regBuyInDetail(BuyDTO buyDTO){
    buyMapper.regBuyInDetail(buyDTO);
  }

  @Transactional(rollbackFor = Exception.class)
  // 장바구니 페이지 구매
  public void regBuyInCart(BuyDTO buyDTO){
    // 장바구니 선택 구매
    buyMapper.regBuyInCart(buyDTO);

    // 장바구니 선택 구매 만큼 삭제
    cartMapper.deleteSelectedCart(buyDTO);
  }

  // 구매 이력 조회
  public List<BuyDTOForAdmin> getBuyListForAdmin(){
    return buyMapper.getBuyListForAdmin();
  }

  // 구매 내역 상세 조회
  public List<BuyDTO> getBuyDetail(int orderNum){
    return buyMapper.getBuyDetail(orderNum);
  }
}
