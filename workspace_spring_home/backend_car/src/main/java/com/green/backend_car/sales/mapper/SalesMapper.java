package com.green.backend_car.sales.mapper;

import com.green.backend_car.sales.mapper.SalesMapper;
import com.green.backend_car.sales.dto.SalesDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SalesMapper {
  // 판매 정보 등록
  void regSales(SalesDTO salesDTO);

  // 판매 정보 조회
  List<SalesDTO> getSalesList();
}
