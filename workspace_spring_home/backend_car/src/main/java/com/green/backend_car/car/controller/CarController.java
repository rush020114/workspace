package com.green.backend_car.car.controller;

import com.green.backend_car.car.dto.CarDTO;
import com.green.backend_car.car.mapper.CarMapper;
import com.green.backend_car.car.service.CarService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {
  private final CarService carService;

  // 차량 등록
  @PostMapping("")
  public void insertCar(@RequestBody CarDTO carDTO){
    log.info(carDTO.toString());
    carService.insertCar(carDTO);
  }

  // 차량 조회 api
  @GetMapping("")
  public List<CarDTO> getCarList(){
    return carService.getCarList();
  }
}
