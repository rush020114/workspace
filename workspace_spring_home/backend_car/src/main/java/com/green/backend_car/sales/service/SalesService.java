package com.green.backend_car.sales.service;

import com.green.backend_car.sales.mapper.SalesMapper;
import com.green.backend_car.sales.dto.SalesDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SalesService {
  private final SalesMapper salesMapper;

  // 판매 정보 등록
  public void regSales (SalesDTO salesDTO){
    salesMapper.regSales(salesDTO);
  }

  // 판매 정보 조회
  public List<SalesDTO> getSalesList(){
    return salesMapper.getSalesList();
  }
}
