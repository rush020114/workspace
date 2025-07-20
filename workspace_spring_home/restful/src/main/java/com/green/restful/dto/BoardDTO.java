package com.green.restful.dto;

import lombok.Getter;
import lombok.Setter;

// lombok라이브러리가 getter,setter를 자동으로 생성해준다.
@Getter
@Setter
public class BoardDTO {
  private int boardNum;
  private String title;
  private String writer;
  private String content;
  private int readCnt;

  public BoardDTO(){
  }

  public BoardDTO(int boardNum, String title, String writer, String content, int readCnt){
    this.boardNum = boardNum;
    this.title = title;
    this.writer = writer;
    this.content = content;
    this.readCnt = readCnt;
  }

  public String toString(){
    return "제목: " + title + ", 글쓴이: " + writer + ", 내용: " + content + ", 조회수: " + readCnt;
  }
}
