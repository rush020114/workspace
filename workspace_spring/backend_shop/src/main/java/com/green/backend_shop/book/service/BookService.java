package com.green.backend_shop.book.service;

import com.green.backend_shop.book.dto.BookDTO;
import com.green.backend_shop.book.dto.BookImgDTO;
import com.green.backend_shop.book.mapper.BookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
  private final BookMapper bookMapper;

  // 도서 목록 조회
  public List<BookDTO> getBookList(){
    return bookMapper.getBookList();
  }

  // 도서 상세 조회
  public BookDTO getBook(int bookNum){
    return bookMapper.getBook(bookNum);
  }

  // 도서 등록
  public void insertBook(BookDTO bookDTO, List<BookImgDTO> bookImgList){
    // BOOK, BOOK_IMG 테이블의 INSERT를 위해 가져온 두 데이터(bookDTO, bookImgList)에는 현재 bookNum이 없는 상태
    // 그래서 쿼리 실행 전 bookDTO, bookImgList 두 변수에 bookNum 데이터를 추가해야 한다.

    // 다음에 들어갈 bookNum 데이터를 조회
    int nextBookNum = bookMapper.getNextBookNum();

    bookDTO.setBookNum(nextBookNum);

    // book 테이블에 도서 정보 insert
    bookMapper.insertBook(bookDTO);

    for(BookImgDTO bookImgDTO : bookImgList){
      bookImgDTO.setBookNum(nextBookNum);
    }

    // book_img 테이블에 도서 이미지 정보 insert
    bookMapper.insertImgs(bookImgList);
  }
}
