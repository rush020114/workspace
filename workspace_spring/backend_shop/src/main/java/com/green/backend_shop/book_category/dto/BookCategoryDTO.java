package com.green.backend_shop.book_category.dto;

import com.green.backend_shop.book_category.mapper.BookCategoryMapper;
import lombok.*;

// @NoArgsConstructor // 매개변수가 하나도 없는 샏성자
// @AllArgsConstructor // 매개변수를 모두 다 갖는 생성자
@Getter
@Setter
@ToString
public class BookCategoryDTO {
  private int cateNum;
  private String cateName;


}