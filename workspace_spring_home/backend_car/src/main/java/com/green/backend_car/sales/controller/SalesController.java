package com.green.backend_car.sales.controller;

import com.green.backend_car.sales.dto.SalesDTO;
import com.green.backend_car.sales.service.SalesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/sales-infos")
public class SalesController {
  private final SalesService salesService;

  // 판매 정보 등록 api
  @PostMapping("")
  public void regSales(@RequestBody SalesDTO salesDTO){
    salesService.regSales(salesDTO);
  }

  // 판매 정보 조회 api
  @GetMapping("")
  public List<SalesDTO> getSalesList(){
    return  salesService.getSalesList();
  }
}
