package com.green.backend_shop.util;

import com.green.backend_shop.book.dto.BookImgDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// 파일 업로드 기능을 제공하는 클래스
public class FileUploadUtil {

  // 단일 파일 업로드 기능
  // 매개변수로 업로드할 파일이 1개 전달됨
  public static BookImgDTO fileUpload(MultipartFile img){
    // 1) 파일 업로드 경로 지정
    String uploadPath = "D:\\01-STUDY\\dev\\workspace\\workspace_spring\\backend_shop\\src\\main\\resources\\upload\\";

    // 2) 파일명 중복방지를 위해 업로드 파일명을 세팅
    // ex) java.jpg -> wibaoenbglkrwe.jpg
    // ex) java.txt -> zwozbonmkdosko.txt
    String attachedFileName = UUID.randomUUID().toString();

    // 원본 파일의 확장자 추출
    String extension = img.getOriginalFilename().substring(img.getOriginalFilename().lastIndexOf('.'));

    // 완성된 업로드할 파일명
    attachedFileName = attachedFileName + extension;

    // 3) 파일 업로드
    // java.io.File
    // 파일이 생성될 경로와 파일명을 세팅
    File f = new File(uploadPath + attachedFileName);

    // 세팅된 경로와 파일명을 실제 파일로 변환
    try{
      img.transferTo(f);
    }catch (Exception e){
      System.out.println(e);
    }

    // BOOK_IMG INSERT에 필요한 데이터를 리턴한다.
    BookImgDTO bookImgDTO = new BookImgDTO();
    bookImgDTO.setOriginImgName(img.getOriginalFilename());
    bookImgDTO.setAttachedImgName(attachedFileName);
    bookImgDTO.setIsMain("Y");
    return bookImgDTO;
  }

  // 다중 업로드 기능
  // 매개변수로 업로드할 파일이 여러개 배열 형태로 전달됨
  public static List<BookImgDTO> multipleFileUpload(MultipartFile[] imgs){
    // 리턴되는 모든 데이터를 저장할 list
    List<BookImgDTO> bookImgList = new ArrayList<>();
    int index = 0;
    for(MultipartFile img : imgs){
      bookImgList.add(fileUpload(img));
      bookImgList.get(index++).setIsMain("N");
    }

    return bookImgList;
  }
}
