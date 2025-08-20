package com.green.backend_shop.book_category.service;

import com.green.backend_shop.book_category.dto.BookCategoryDTO;
import com.green.backend_shop.book_category.mapper.BookCategoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookCategoryService {
  private final BookCategoryMapper bookCategoryMapper;

  public List<BookCategoryDTO> getCateList(){
    return bookCategoryMapper.getCateList();
  }
}
