package com.green.restful.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BookDTO {
  private int bookNum;
  private String title;
  private String writer;
  private String info;
  private int price;

  public BookDTO(int bookNum, String title, String writer, String info, int price) {
    this.bookNum = bookNum;
    this.title = title;
    this.writer = writer;
    this.info = info;
    this.price = price;
  }

  public BookDTO(){
  }

}
