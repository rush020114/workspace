package com.green.backend_shop.cart.mapper;

import com.green.backend_shop.buy.dto.BuyDTO;
import com.green.backend_shop.cart.dto.CartDTO;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CartMapper {
  // 장바구니 물품 등록
  void insertCart(CartDTO cartDTO);

  // 장바구니 목록 조회
  List<CartDTO> getCartList(String memId);

  // 장바구니에 등록하려는 상품이 현재 등록되어 있는지 확인
  String getCartNum(CartDTO cartDTO);

  // 장바구니 수량 변경
  void updateCartCnt(CartDTO cartDTO);

  // 장바구니 삭제
  int deleteCart(int cartCnt);

  // 장바구니 페이지 수량 변경
  void updateCart(CartDTO cartDTO);

  // 장바구니 구매 시 데이터 삭제
  void deleteBuyCart(BuyDTO buyDTO);
}
