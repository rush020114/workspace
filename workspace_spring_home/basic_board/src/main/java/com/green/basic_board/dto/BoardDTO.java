package com.green.basic_board.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
// 테이블과 데이터를 주고받기 위한 클래스
public class BoardDTO {
  private int boardNum;
  private String title;
  private String writer;
  private String content;
  private int readCnt;
  private LocalDateTime createDate; // 날짜에 대한 자료형

  public BoardDTO(){
  }
}
