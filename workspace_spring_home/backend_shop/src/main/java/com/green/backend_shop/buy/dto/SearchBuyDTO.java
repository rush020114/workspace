package com.green.backend_shop.buy.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// 통상적으로 검색 데이터를 받아올 dto는 따로 만든다.
@Getter
@Setter
@ToString
public class SearchBuyDTO {
  // 원래 orderNum은 정수자료형이지만 리액트에서 넘어올 때
  // 빈문자가 넘어오면 받지 못하므로 문자열 자료형을 쓴다.
  // 또한 mariadb는 문자열을 정수로 변환시켜 데이터를 조회해준다.
  private String orderNum;
  private String memId;
  // 날짜라도 리액트에서 넘어오는 데이터는 문자열이다.
  // 또한 mariadb에서는 문자열 데이터로도 날짜데이터와 비교가 가능하다.
  private String fromDate;
  private String toDate;
}
