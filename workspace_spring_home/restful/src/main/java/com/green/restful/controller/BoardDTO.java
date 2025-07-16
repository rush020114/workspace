package com.green.restful.controller;

import lombok.Getter;
import lombok.Setter;

// lombok라이브러리가 getter,setter를 자동으로 생성해준다.
@Getter
@Setter
public class BoardDTO {
  private String title;
  private String writer;
  private String content;

  public String toString(){
    return "제목: " + title + ", 글쓴이: " + writer + ", 내용: " + content;
  }
}
