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

  // 도서 등록
  // 도서 등록 때 실행할 쿼리는 3개이지만 등록이라는 기능 안에서 쿼리 3개가 실행되므로
  // 핵심 기능을 구현하는 service에서는 메서드 하나이면 충분하다.
  // 이미지 테이블의 빈값을 채우기 위해서는 list(list안의 dto가 빈값을 다 갖게 됨)가 필요하다.
  public void insertBook(BookDTO bookDTO, List<BookImgDTO> bookImgDTOList){
    // 등록할 도서번호를 조회
    int nextBookNum = bookMapper.getNextBookNum();

    // 도서 등록
    // 기존에 전달된 bookDTO를 채운 값엔 bookNum이 없으므로
    // 위의 리턴값을 이용해 세팅한다.
    bookDTO.setBookNum(nextBookNum);
    bookMapper.insertBook(bookDTO);

    // 도서 이미지 등록
    // 이미지의 빈값 중 채워지지 않은 값은 bookNum뿐이므로
    // service에서 그 값을 세팅해준다. 여러 개이므로 반복문으로 채워준다.
    // 책 한 권 등록될 때 이미지가 등록되므로 이미지 등록 시 채우는 책번호는 모두 동일해야 한다.
    for(BookImgDTO bookImgDTO : bookImgDTOList){
      bookImgDTO.setBookNum(nextBookNum);
    }
    // 도서 이미지 등록 시 필요한 모든 데이터를 포함하여 쿼리를 실행
    bookMapper.insertBookImg(bookImgDTOList);

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
