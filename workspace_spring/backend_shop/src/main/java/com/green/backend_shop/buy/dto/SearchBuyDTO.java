package com.green.backend_shop.buy.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
// 구매 목록 페이지에서 전달되는 검색 데이터를 담기 위한 클래스
public class SearchBuyDTO {
  // db에서 where절을 조회할 때 숫자자리도 문자열로 조회할 때 자동으로 숫자로 바꿔주기 때문에 string으로 db에 넘긴다.
  private String orderNum;
  private String memId;
  // 날짜로 정한 인풋값은 리액트에서 문자로 넘어온다.
  private String fromDate;
  private String toDate;
}
