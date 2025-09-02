package com.green.backend_car.car.controller;

import com.green.backend_car.car.dto.CarDTO;
import com.green.backend_car.car.service.CarService;
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

  // 차량 등록 api
  @PostMapping("")
  public void regCar (@RequestBody CarDTO carDTO){
    carService.regCar(carDTO);
  }

  // 차량 목록 조회 api
  @GetMapping("")
  public List<CarDTO> getCarList(){
    return carService.getCarList();
  }
}
