package com.green.backend_shop.book.controller;

import com.green.backend_shop.book.dto.BookDTO;
import com.green.backend_shop.book.dto.BookImgDTO;
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
  // 두번째 매개변수는 'subImgs'라는 이름으로 전달되는 배열 데이터 여러개를 받는다.
  // 세번째 매개변수는 파일 데이터가 아닌 입력한 도서 정보를 받는다. (이때 객체가 아닌 formData를 활용해 전달되어 기존과 다르다.)
  // formData로 전달되는 데이터를 받을 때는 전달되는 데이터의 key와 동일한 이름을 멤버변수로 갖는 dto클래스로 받을 수 있다.(어노테이션 붙지 않음)

  // requestParam 어노테이션의 사용법
  // ex) @RequestParam("img") : "img"라는 이름으로 전달되는 데이터를 받겠다. (name속성 자동 생성, 데이터 안 넘어오면 오류)
  // ex) @RequestParam(name="img") : "img"라는 이름으로 전달되는 데이터를 받겠다. (데이터 안 넘어오면 오류)
  // ex) @RequestParam(name="img", required=false) : "img"라는 이름으로 전달되는 데이터를 받겠다. (데이터 필수 아님)
  // required: 넘어오는 데이터가 필수인지를 정하는 속성
  @PostMapping("")
  public void insertBook(@RequestParam("mainImg") MultipartFile mainImg
                          , @RequestParam(name = "subImgs", required = false) MultipartFile[] subImgs
                          , BookDTO bookDTO){

    // 1. 이미지 파일 업로드(server pc에 파일을 저장한다).
    BookImgDTO bookImgDTO = FileUploadUtil.fileUpload(mainImg); // 단일 파일 업로드
    List<BookImgDTO> bookImgList = FileUploadUtil.multipleFileUpload(subImgs);
    bookImgList.add(bookImgDTO);

    // imgList에 bookNum만 추가하면 끝!
    // book 테이블에 insert한 bookNum과 동일한 데이터가 book_img테이블에 등록되어야 함

    // 2. book 테이블, book_img 테이블에 데이터 insert
    // 도서 등록 기능은 하나면 충분하기에 service에는 하나의 메서드만 만든다.
    bookService.insertBook(bookDTO, bookImgList);
  }
}
