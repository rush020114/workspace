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
@RequestMapping("/buys")
@RequiredArgsConstructor
public class BuyController {
  private final BuyService buyService;

  // 도서 구매 api
  @PostMapping("")
  public ResponseEntity<?> buyBook (@RequestBody BuyDTO buyDTO){
    // 서버에서 응답을 해줄 땐 http규약에 맞춰서 응답해야 한다.
    // 하지만 이때까지 body에만 데이터를 넣어 응답했다.
    // responseEntity를 이용해 status, header까지 넘겨줄 수 있다.
    // 아직 header까진 넘길 필요 없지만 status는 꼭 넘겨주어야 한다.
    // 혹시 모를 예외상황을 frontend개발자에게 알려주기 위해 try catch문에 예외상황도 넘긴다.
    // 등록됐을 땐 created를 전달한다.
    // 등록됐을 때 body로 넘길 데이터가 없으면 build를 쓴다.
    // return타입은 responseEntity인데 ?는 와일드카드로 자료형을 알아서 인식해 반환한다.
    // 서버에서 발생하는 오류는 500이므로 status에 internal_server_error를 쓴다.
    // body에 메시지를 보내면 frontend에서 서버에서 보낸 오류 내용을 확인할 수 있다.
    // 만약 header를 보내고 싶다면 status다음에 header나 headers 메서드를 호출한다.
    // headers 매개변수에는 HttpHeaders enum 객체를 생성 후 add("문자열(키)", "문자열(value)")해주고 그 변수를 넣어준다.
    // header메개변수에는 바로 ("문자열(키)", "문자열(value)")형식으로 데이터를 넣어준다.
    try {
      buyService.buyBook(buyDTO);
      return ResponseEntity
              .status(HttpStatus.CREATED)
              .build();
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity
              .status(HttpStatus.INTERNAL_SERVER_ERROR)
              .body("쿼리 실행 오류");
    }

  }

  // 장바구니 도서 구매 api
  @PostMapping("/carts")
  public void buyCartBook(@RequestBody BuyDTO buyDTO){
    buyService.buyCartBook(buyDTO);
  }

  // 주문번호에 따른 관리자의 사용자 구매이력 조회 api
  @GetMapping("buy-list-admin")
  public List<BuyDTOForAdmin> getBuyListForAdmin(SearchBuyDTO searchBuyDTO){
    log.info(searchBuyDTO.toString());
    return buyService.getBuyListForAdmin(searchBuyDTO);
  }

  // 구매 내역 상세 조회
  @GetMapping("/{orderNum}")
  public ResponseEntity<?> getBuyDetail(@PathVariable("orderNum") int orderNum){

    try {
      // 조회 성공 시에는 ok를 쓴다.
      return ResponseEntity
              .status(HttpStatus.OK)
              .body(buyService.getBuyDetail(orderNum));
    }catch (Exception e){
      return ResponseEntity
              .status(HttpStatus.INTERNAL_SERVER_ERROR)
              .build();
    }
  }

  // 현재일로부터 -10일까지 날짜 데이터 조회
  @GetMapping("/date-10-day")
  public List<String> getTenDay(){
    return buyService.getTenDay();
  }

  // 10일 간 각각의 매출 조회
  @GetMapping("/sales-10-day")
  public List<Integer> getSalesTenDay(){
    return buyService.getSalesTenDay();
  }
}
