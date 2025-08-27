package com.green.backend_shop.book.mapper;

import com.green.backend_shop.book.dto.BookDTO;
import com.green.backend_shop.book.dto.BookImgDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {
  // 도서 등록
  void insertBook(BookDTO bookDTO);

  // 등록될 도서 번호 조회 쿼리 실행
  int getNextBookNum();

  // 도서 이미지 등록
  // 도서 하나가 등록될 때는 여러 개의 이미지가 함께 등록된다.
  // 도서 이미지의 빈값은 이미지 수만큼 늘어난다.
  // 빈값은 dto로 채우는데 dto가 여러 개 필요하므로 list로 빈값을 채운다.
  void insertBookImg(List<BookImgDTO> bookImgDTOList);

  // 도서 목록 조회
  List<BookDTO> getBookList();

  // 도서 상세 조회
  BookDTO getBook(int bookNum);
}
