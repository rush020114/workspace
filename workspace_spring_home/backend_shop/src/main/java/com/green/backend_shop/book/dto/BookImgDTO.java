package com.green.backend_shop.book.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
// 원래 package를 분리하여 dto를 작성하는 것이 원칙이지만
// 기능을 하나만 구현하면 되기에 예외적으로 같이 만들어주었다.
public class BookImgDTO {
  private int imgNum;
  private String originImgName;
  private String attachedImgName;
  private int bookNum;
  private String isMain;

  public BookImgDTO(){
  }

}
