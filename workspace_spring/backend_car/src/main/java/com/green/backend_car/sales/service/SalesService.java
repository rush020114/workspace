package com.green.backend_car.sales.service;

import com.green.backend_car.sales.dto.SalesDTO;
import com.green.backend_car.sales.mapper.SalesMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SalesService {
  private final SalesMapper salesMapper;

  // 판매 정보 등록
  public void insertSalesInfo(SalesDTO salesDTO){
    if(salesDTO.getBuyerTel().equals("")){
      salesDTO.setBuyerTel(null);
    }
    salesMapper.insertSalesInfo(salesDTO);
  }

  // 판매 목록 조회
  public List<SalesDTO> getSalesList(){
    return salesMapper.getSalesList();
  }
}
