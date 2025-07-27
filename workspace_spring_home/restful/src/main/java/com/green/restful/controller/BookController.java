package com.green.restful.controller;

import com.green.restful.dto.BookDTO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {
  @GetMapping("/books")
  public List<BookDTO> getBookList(){
    List<BookDTO> bookDTOList = new ArrayList<>();
    bookDTOList.add(new BookDTO(1, "자바기초", "김개발", "내용1", 20000));
    bookDTOList.add(new BookDTO(2, "웹페이지제작하기", "윤개발", "내용2", 15000));
    bookDTOList.add(new BookDTO(3, "리액트따라하기", "박개발", "내용3", 30000));
    bookDTOList.add(new BookDTO(4, "동남아여행", "김여행", "내용4", 15000));
    bookDTOList.add(new BookDTO(5, "한식레시피", "이요리", "내용5", 20000));
    return bookDTOList;
  }

  @GetMapping("books/{bookNum}")
  public String getBookInfo(@PathVariable("bookNum") int bookNum){
    System.out.println(bookNum);
    return "조회 성공";
  }

  @PostMapping("books")
  public String insertBookINfo(@RequestBody BookDTO bookDTO){
    System.out.println(bookDTO);
    return "등록 성공";
  }

  @DeleteMapping("books/{bookNum}")
  public String deleteBookInfo(@PathVariable("bookNum") int bookNum){
    System.out.println(bookNum);
    return "삭제 성공";
  }

  @PutMapping("books/{bookNum}")
  public String updateBookInfo(@RequestBody BookDTO bookDTO, @PathVariable("bookNum") int bookNum){
    System.out.println(bookNum);
    System.out.println(bookDTO);
    return "수정 성공";
  }
}
