package com.green.backend_shop.book.controller;

import com.green.backend_shop.book.dto.BookDTO;
import com.green.backend_shop.book.service.BookService;
import com.green.backend_shop.util.FileUploadUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.UUID;

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
  // 첨부파일 데이터를 받을 때는 MultipartFile 자료형으로 받아야 한다.
  // 첫번째 매개변수는 'mainImg'라는 이름으로 전달되는 파일 데이터를 받는다.
  @PostMapping("")
  public void insertBook(@RequestParam("mainImg") MultipartFile mainImg){
    // 1. 이미지 파일 업로드(server pc에 파일을 저장한다).
    FileUploadUtil.fileUpload(mainImg);

    // 2. book 테이블에 데이터 insert
    // bookService.insertBook(bookDTO);
    // 3. book_img 테이블에 데이터 insert
  }

}
