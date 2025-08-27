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
  private List<BookImgDTO> bookImgDTOList;

  public BookDTO(){
  }
}
