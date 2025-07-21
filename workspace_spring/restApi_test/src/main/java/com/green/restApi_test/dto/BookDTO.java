package com.green.restApi_test.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDTO {
  private int bookNum;
  private String title;
  private String writer;
  private String summary;
  private int price;

  public BookDTO(){
  }

  public BookDTO(int bookNum, String title, String writer, String summary, int price){
    this.bookNum = bookNum;
    this.title = title;
    this.writer = writer;
    this.summary = summary;
    this.price = price;
  }

  public String toString(){
    return "도서번호: " + bookNum + ", 도서명: " + title + ", 저자: " + writer + ", 도서소개: " + summary + ", 도서 가격: " + price;
  }
}
