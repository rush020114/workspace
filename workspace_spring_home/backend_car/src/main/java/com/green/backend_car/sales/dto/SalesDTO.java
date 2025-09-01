package com.green.backend_car.sales.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SalesDTO {
  private int salesNum;
  private String buyer;
  private String buyerTel;
  private String color;
  private LocalDateTime salesDate;
  private int modelNum;
}
