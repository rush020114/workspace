package com.green.backend_shop.buy.service;

import com.green.backend_shop.buy.dto.BuyDTO;
import com.green.backend_shop.buy.mapper.BuyMapper;
import com.green.backend_shop.cart.mapper.CartMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BuyService {
  private final BuyMapper buyMapper;
  private final CartMapper cartMapper;

  // 상세 페이지 물품 구매
  public void insertDetailBuy (BuyDTO buyDTO){
    buyMapper.insertDetailBuy(buyDTO);
  }

  // 장바구니 물품 구매
  // 장바구니 선택 구매 시 데이터가 삭제되므로 장바구니 service를 활용하는 것이 아니라
  // 선택 구매 기능을 만드는 것이므로 service에 기능(메서드를)을 활용한다.
  // 구매는 1. shop_buy 테이블에 insert쿼리와
  // 2. shop_cart 테이블에 delete 쿼리
  // 두 쿼리의 실행으로 이루어져 있다.
  // 두 쿼리는 둘 다 성공해서 성공으로 판단할 수 있기 때문에
  // transaction을 사용하여 두 쿼리를 하나의 묶음으로 간주해야 한다.
  // @Transactional어노테이션이 선언된 메서듸 내의 모든 쿼리는 하나의 묶음으로 간주함.
  // -> 메서드 내 모든 쿼리실행 명령어가 정상 작동 되어야지만 commit을 진행함.
  // rollbackFor : 이 속성에는 어떤 경우에 롤백을 진행할지 설정할 수 있는 속성
  // Exception.class 의미는 모든 오류에 대해 (이유 불문하고) 오류가 발생하면 무조건 롤백시키겠다라는 의미
  @Transactional(rollbackFor = Exception.class)
  public void buyAll (BuyDTO buyDTO){
    // shop_buy 테이블에 구매 정보를 insert
    buyMapper.buyAll(buyDTO);

    // 구매한 장바구니 정보는 shop_cart 테이블에서 delete
    cartMapper.deleteBuyCart(buyDTO);
  }
}
