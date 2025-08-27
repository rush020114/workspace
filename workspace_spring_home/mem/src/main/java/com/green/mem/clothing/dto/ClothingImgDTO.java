package com.green.mem.clothing.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ClothingImgDTO {
  private int imgNum;
  private String originImgName;
  private String attachedImgName;
  private int clothingNum;
  private String isMain;

  public ClothingImgDTO(){
  }
}
