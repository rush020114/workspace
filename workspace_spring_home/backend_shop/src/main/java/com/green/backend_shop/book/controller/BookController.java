package com.green.backend_shop.book.controller;

import com.green.backend_shop.book.dto.BookDTO;
import com.green.backend_shop.book.dto.BookImgDTO;
import com.green.backend_shop.book.service.BookService;
import com.green.backend_shop.util.FileUploadUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j // 이 어노테이션 사용 후 이 어노테이션 관련 메서드를 사용하면 로그(흔적)를 남길 수 있다.
// log.info 메서드는 로그에 정보를 남기겠다는 뜻 (출력문과의 차이는 메모장에 저장할 수 있고 없고의 차이(출력문은 안 됨))
@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {
  private final BookService bookService;

  // 도서 등록 api
  // formData로 들어온 데이터는 RequestParam어노테이션으로 받는다.(mainImg라는 이름으로 전달했으므로 mainImg로 받는다.)
  // 파일 데이터는 자료형이 MultipartFile이다.
  // @requestParams의 name속성은 전달된 파일의 키값이다. required속성은 파일 전달이 필수인지를 결정하는 속성이다.(false는 필수 전달 아님이라는 뜻)
  // 책 등록하기 위해 넘긴 일반 데이터는 formData로 넘어왔기 때문에 어노테이션 없이 받으면 된다.
  @PostMapping("")
  public void insertBook (@RequestParam("mainImg") MultipartFile mainImg
                          , @RequestParam(name = "subImgs", required = false) MultipartFile[] subImgs
                          , BookDTO bookDTO){

    // 각각 등록 시 쿼리의 빈값을 채워줄 메서드의 리턴값을 받은 상태이다(책번호 제외).
    BookImgDTO bookImgDTO = FileUploadUtil.fileUpload(mainImg);
    List<BookImgDTO> bookImgDTOList = FileUploadUtil.multipleFileUpload(subImgs);

    // 도서 등록 시 필요한 이미지 만큼의 데이터 세팅(메인 1개, 서브 여러개)
    bookImgDTOList.add(bookImgDTO);

    // 도서 등록 기능 실행(bookDTO엔 책번호 없음)
    bookService.insertBook(bookDTO, bookImgDTOList);
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
