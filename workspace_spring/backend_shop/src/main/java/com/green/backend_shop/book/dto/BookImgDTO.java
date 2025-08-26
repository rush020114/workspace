package com.green.backend_shop.book.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BookImgDTO {
  private int imgNum;
  private String originImgName;
  private String attachedImgName;
  private int bookNum;
  private String isMain;

  public BookImgDTO(){
  }
}
