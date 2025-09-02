package com.green.backend_car.car.service;

import com.green.backend_car.car.dto.CarDTO;
import com.green.backend_car.car.mapper.CarMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {
  private final CarMapper carMapper;

  // 차량 등록
  public void insertCar(CarDTO carDTO){
    carMapper.insertCar(carDTO);
  }

  // 차량 조회
  public List<CarDTO> getCarList(){
    return carMapper.getCarList();
  }
}
