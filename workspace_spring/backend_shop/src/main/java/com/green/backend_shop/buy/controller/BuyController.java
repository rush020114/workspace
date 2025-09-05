package com.green.backend_shop.buy.controller;

import com.green.backend_shop.buy.dto.BuyDTO;
import com.green.backend_shop.buy.dto.BuyDTOForAdmin;
import com.green.backend_shop.buy.dto.SearchBuyDTO;
import com.green.backend_shop.buy.service.BuyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
  public void insertDetailBuy (@RequestBody BuyDTO buyDTO){
    buyService.insertDetailBuy(buyDTO);
  }

  // 장바구니 물품 구매 api
  @PostMapping("/all")
  public void buyAll(@RequestBody BuyDTO buyDTO){
    log.info(buyDTO.toString());
    buyService.buyAll(buyDTO);
  }

  // 관리자 구매이력조회 페이지의 구매목록조회 api
  @GetMapping("/buy-list-admin")
  public List<BuyDTOForAdmin> getBuyListForAdmin(SearchBuyDTO searchBuyDTO){
    log.info(searchBuyDTO.toString());
    return buyService.getBuyListForAdmin(searchBuyDTO);
  }

  // 구매 상세 내역 조회
  @GetMapping("/{orderNum}")
  public List<BuyDTO> getDetailBuy(@PathVariable("orderNum") int orderNum){
    return buyService.getDetailBuy(orderNum);
  }
}
