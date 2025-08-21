package com.green.backend_shop.book.service;

import com.green.backend_shop.book.dto.BookDTO;
import com.green.backend_shop.book.mapper.BookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
  private final BookMapper bookMapper;

  // 도서 등록
  public int insertBook(BookDTO bookDTO){
    return bookMapper.insertBook(bookDTO);
  }

  // 도서 목록 조회
  public List<BookDTO> getBookList(){
    return bookMapper.getBookList();
  }

  // 도서 상세 조회
  public BookDTO getBook(int bookNum){
    return bookMapper.getBook(bookNum);
  }
}
