package com.green.backend_car.sales.mapper;

import com.green.backend_car.sales.dto.SalesDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SalesMapper {
  // 판매 정보 등록
  void insertSalesInfo(SalesDTO salesDTO);
}
