package com.green.backend_shop.buy.controller;

import com.green.backend_shop.buy.dto.BuyDTO;
import com.green.backend_shop.buy.dto.BuyDTOForAdmin;
import com.green.backend_shop.buy.dto.SearchBuyDTO;
import com.green.backend_shop.buy.service.BuyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("buys")
@RequiredArgsConstructor
public class BuyController {
  private final BuyService buyService;

  // 상세 페이지 물품 구매 api
  @PostMapping("")
  public ResponseEntity<?> insertDetailBuy (@RequestBody BuyDTO buyDTO){
    try {
      buyService.insertDetailBuy(buyDTO);
      return ResponseEntity.status(HttpStatus.CREATED).build();
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity
              .status(HttpStatus.INTERNAL_SERVER_ERROR)
              .body("구매하기 쿼리 실행 중 오류가 발생했습니다.");
    }
  }

  // 장바구니 물품 구매 api
  @PostMapping("/all")
  public void buyAll(@RequestBody BuyDTO buyDTO){
    log.info(buyDTO.toString());
    buyService.buyAll(buyDTO);
  }

  // 관리자 구매이력조회 페이지의 구매목록조회 api
  @GetMapping("/buy-list-admin")
  public ResponseEntity<?> getBuyListForAdmin(SearchBuyDTO searchBuyDTO){
    log.info(searchBuyDTO.toString());

    try {
      // 구매 목록
      List<BuyDTOForAdmin> list = buyService.getBuyListForAdmin(searchBuyDTO);
      return ResponseEntity.status(HttpStatus.OK).body(list);
    } catch (Exception e){
      e.printStackTrace();
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }

  // 구매 상세 내역 조회
  @GetMapping("/{orderNum}")
  public List<BuyDTO> getDetailBuy(@PathVariable("orderNum") int orderNum){
    return buyService.getDetailBuy(orderNum);
  }

  // 10일에 해당되는 날짜 조회
  @GetMapping("/date-10-day")
  public List<String> get10Days(){
    return buyService.get10Days();
  }

  // 10일 간 매출
  @GetMapping("/sales-10-day")
  public List<Integer> getSales10Days(){
    return buyService.getSales10Days();
  }
}
