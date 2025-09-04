package com.green.backend_shop.buy.service;

import com.green.backend_shop.buy.dto.BuyDTO;
import com.green.backend_shop.buy.dto.BuyDTOForAdmin;
import com.green.backend_shop.buy.mapper.BuyMapper;
import com.green.backend_shop.cart.mapper.CartMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BuyService {
  private final BuyMapper buyMapper;
  private final CartMapper cartMapper;

  // 도서 구매
  public void buyBook(BuyDTO buyDTO){
    buyMapper.buyBook(buyDTO);
  }

  // 장바구니 도서 구매
  // 장바구니 구매 목록 삭제는 장바구니에서 상품이 구매될 시 진행되기 때문에
  // 기능이 하나고 쿼리가 여러개인 경우라고 볼 수 있다.
  // 기능이 하나일 땐 service의 한 메서드에 작성하는 것이 원칙이다.
  // 이를 어기면 transaction을 적용할 수 없어 예외 상황을 처리할 수가 없다.
  // transaction은 간단히 설명하면 한 메서드에서 여러 쿼리를 한 묶음으로 묶어주는 것이다.
  // 그러면 한 쿼리가 잘못되면 이전에 실행된 모든 쿼리를 rollback시키고 다 완료될 때만 commit을 하여 오류를 예방할 수 있다.
  @Transactional(rollbackFor = Exception.class)
  public void buyCartBook(BuyDTO buyDTO){
    // 장바구니 구매
    buyMapper.buyCartBook(buyDTO);

    // 장바구니 구매 시 삭제
    cartMapper.deleteCarts(buyDTO);
  }

  // 주문번호에 따른 관리자의 사용자 구매이력 조회
  public List<BuyDTOForAdmin> getBuyListForAdmin(){
    System.out.println(buyMapper.getBuyListForAdmin());
    return buyMapper.getBuyListForAdmin();
  }

  // 구매 내역 상세 조회
  public List<BuyDTO> getBuyDetail(int orderNum){
    return buyMapper.getBuyDetail(orderNum);
  }
}
