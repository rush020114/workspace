package com.green.mem.buy.controller;

import com.green.mem.buy.dto.BuyDTO;
import com.green.mem.buy.dto.BuyDTOForAdmin;
import com.green.mem.buy.dto.SearchBuyDTO;
import com.green.mem.buy.service.BuyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/buys")
@RequiredArgsConstructor
public class BuyController {
  private final BuyService buyService;

  // 상세 페이지 구매 api
  @PostMapping("")
  public void regBuyInDetail(@RequestBody BuyDTO buyDTO){
    buyService.regBuyInDetail(buyDTO);
  }

  // 장바구니 페이지 구매
  @PostMapping("/cart-buy")
  public void regBuyInCart(@RequestBody BuyDTO buyDTO){
    buyService.regBuyInCart(buyDTO);
  }

  // 구매 이력 조회 api
  @GetMapping("/buy-list-admin")
  public List<BuyDTOForAdmin> getBuyListForAdmin(SearchBuyDTO searchBuyDTO){
    return buyService.getBuyListForAdmin(searchBuyDTO);
  }

  // 구매 내역 상세 조회 api
  @GetMapping("/buy-detail/{orderNum}")
  public List<BuyDTO> getBuyDetail(@PathVariable("orderNum") int orderNum){
    return  buyService.getBuyDetail(orderNum);
  }
}
