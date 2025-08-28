package com.green.backend_shop.book.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
public class BookDTO {
  private int bookNum;
  private String title;
  private String publisher;
  private int price;
  private LocalDateTime regDate;
  private String bookIntro;
  private int cateNum;
  // book테이블 조회 시 여러 이미지가 필요하다.
  // book테이블을 기준으로 조회하므로 두 테이블은 1 : n의 관계가 성립한다.
  private List<BookImgDTO> bookImgDTOList;

  public BookDTO(){
  }
}
