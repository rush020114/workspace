package com.green.backend_car.car.mapper;

import com.green.backend_car.car.dto.CarDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CarMapper {
  // 차량 등록
  void regCar (CarDTO carDTO);
}
