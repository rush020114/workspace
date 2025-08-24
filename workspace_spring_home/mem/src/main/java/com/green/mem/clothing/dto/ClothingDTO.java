package com.green.mem.clothing.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class ClothingDTO {
  private int clothingNum;
  private String clothingName;
  private String brand;
  private int price;
  private LocalDateTime regDate;
  private String clothingIntro;
  private int cateNum;

  public ClothingDTO(){
  }

}
