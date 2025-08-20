package com.green.backend_shop.book.mapper;

import com.green.backend_shop.book.dto.BookDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {
  // 도서 목록 조회
  List<BookDTO> getBookList();

  // 도서 상세 조회
  BookDTO getBook(int bookNum);

  // 도서 등록
  int insertBook(BookDTO bookDTO);
}