package com.green.backend_shop.book.controller;

import com.green.backend_shop.book.dto.BookDTO;
import com.green.backend_shop.book.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j // 이 어노테이션 사용 후 이 어노테이션 관련 메서드를 사용하면 로그(흔적)를 남길 수 있다.
// log.info 메서드는 로그에 정보를 남기겠다는 뜻 (출력문과의 차이는 메모장에 저장할 수 있고 없고의 차이(출력문은 안 됨))
@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {
  private final BookService bookService;

  // 도서 등록 api
  @PostMapping("")
  public int insertBook (@RequestBody BookDTO bookDTO){
    return bookService.insertBook(bookDTO);
  }

  // 도서 목록 조회 api
  @GetMapping("")
  public List<BookDTO> getBookList(){
    return bookService.getBookList();
  }

  // 도서 상세 조회 api
  @GetMapping("/{bookNum}")
  public BookDTO getBook(@PathVariable("bookNum") int bookNum){
    return bookService.getBook(bookNum);
  }

}
