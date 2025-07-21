package com.green.restApi_test.controller;

import com.green.restApi_test.dto.BookDTO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {
  @GetMapping("/books")
  public List<BookDTO> getBookList(){
    List<BookDTO> bookDTOList = new ArrayList<>();
    bookDTOList.add(new BookDTO(1, "자바 기초", "김개발", "자바에 대한 기초를 배울 수 있습니다.", 20000));
    bookDTOList.add(new BookDTO(2, "웹 페이지 제작하기", "윤개발", "웹페이지를 제작할 수 있습니다.", 15000));
    bookDTOList.add(new BookDTO(3, "리액트 따라하기", "박개발", "리액트를 따라할 수 있습니다.", 30000));
    bookDTOList.add(new BookDTO(4, "동남아 여행", "김여행", "동남아 여행을 다닐 수 있습니다.", 15000));
    bookDTOList.add(new BookDTO(5, "한식 레시피", "이요리", "한식을 만들 수 있습니다.", 20000));
    return bookDTOList;
  }

  @GetMapping("/books/{bookNum}")
  public String getBook(@PathVariable("bookNum") int bookNum){
    System.out.println("bookNum: " + bookNum);
    return "하나의 도서정보 조회 완료";
  }

  @PostMapping("/books")
  public String insertBook(@RequestBody BookDTO bookDTO){
    System.out.println(bookDTO);
    return "하나의 도서정보를 등록 완료";
  }

  @DeleteMapping("/books/{bookNum}")
  public String deleteBook(@PathVariable("bookNum") int bookNum){
    System.out.println("bookNum: " + bookNum);
    return "하나의 도서정보를 삭제 완료";
  }

  @PutMapping("/books/{bookNum}")
  public String updateBook(@PathVariable("bookNum") int bookNum, @RequestBody BookDTO bookDTO){
    System.out.println("bookNum: " + bookNum);
    System.out.println(bookDTO);
    return "하나의 도서정보에서 도서명과 저자, 도서가격을 수정 완료";
  }
}
