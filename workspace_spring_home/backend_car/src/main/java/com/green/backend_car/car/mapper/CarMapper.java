package com.green.backend_car.car.mapper;

import com.green.backend_car.car.dto.CarDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CarMapper {
  // 차량 등록
  void insertCar(CarDTO carDTO);

  // 차량 조회
  List<CarDTO> getCarList();
}
