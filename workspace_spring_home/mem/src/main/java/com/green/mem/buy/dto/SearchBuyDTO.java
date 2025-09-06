package com.green.mem.buy.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SearchBuyDTO {
  private String orderNum;
  private String memId;
  private String fromDate;
  private String toDate;

  public SearchBuyDTO(){
  }
}
