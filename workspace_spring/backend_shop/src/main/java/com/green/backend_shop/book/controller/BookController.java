package com.green.backend_shop.book.controller;

import com.green.backend_shop.book.dto.BookDTO;
import com.green.backend_shop.book.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {
  private final BookService bookService;

  // 도서 목록 조회
  @GetMapping("")
  public List<BookDTO> getBookList(){
    return bookService.getBookList();
  }

  // 도서 상세 조회
  @GetMapping("/{bookNum}")
  public BookDTO getBook(@PathVariable("bookNum") int bookNum){
    return bookService.getBook(bookNum);
  }

  // 도서등록 api
  @PostMapping("")
  public int insertBook(@RequestBody BookDTO bookDTO){
    log.info(bookDTO.toString());
    return bookService.insertBook(bookDTO);
  }
}
