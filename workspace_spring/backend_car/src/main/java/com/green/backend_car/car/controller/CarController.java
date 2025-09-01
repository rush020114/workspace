package com.green.backend_car.car.controller;

import com.green.backend_car.car.dto.CarDTO;
import com.green.backend_car.car.service.CarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
