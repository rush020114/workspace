package com.green.backend_shop.book_category.controller;

import com.green.backend_shop.book_category.dto.BookCategoryDTO;
import com.green.backend_shop.book_category.service.BookCategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j // 로그를 남긴다.
@RestController
@RequiredArgsConstructor
@RequestMapping("/book-categories")
public class BookCategoryController {
  private final BookCategoryService bookCategoryService;

  // 도서 카테고리 목록 조회 api
  @GetMapping("")
  public List<BookCategoryDTO> getCateList (){
    log.info(bookCategoryService.getCateList().toString()); // 출력보다 더 나은 방법
    return bookCategoryService.getCateList();
  }
}
