package com.green.backend_shop.book.service;

import com.green.backend_shop.book.dto.BookDTO;
import com.green.backend_shop.book.mapper.BookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {
  private final BookMapper bookMapper;

  // 도서 등록
  public int insertBook(BookDTO bookDTO){
    return bookMapper.insertBook(bookDTO);
  }
}
