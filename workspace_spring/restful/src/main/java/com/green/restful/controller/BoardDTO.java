package com.green.restful.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDTO {
  private String title;
  private String writer;
  private String content;

  @Override
  public String toString(){
    return "제목 : " + title + ", 작성자 : " + writer + ", 내용 : " + content;
  }

}
