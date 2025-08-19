package com.green.backend_shop.book.controller;

import com.green.backend_shop.book.dto.BookDTO;
import com.green.backend_shop.book.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {
  private BookService bookService;

  public BookController(BookService bookService){
    this.bookService = bookService;
  }

  // 도서등록 api
  @GetMapping("")
  public int insertBook(@RequestBody BookDTO bookDTO){
    return bookService.insertBook(bookDTO);
  }
}
