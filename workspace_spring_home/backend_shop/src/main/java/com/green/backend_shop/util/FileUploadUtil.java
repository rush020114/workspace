package com.green.backend_shop.util;

import com.green.backend_shop.book.dto.BookImgDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// 파일 업로드 메서드를 갖고 있는 클래스를 만들어 파일을 업로드하고 싶을 때 쉽게 메서드를 호출하여 이용할 수 있다.
public class FileUploadUtil {
  // 객체 생성 없이 사용해도 상관 없으므로 static을 사용
  public static BookImgDTO fileUpload(MultipartFile img){
    // 파일을 server에 저장하기 위해서는 경로와 파일명(랜덤)을 설정해주어야 한다.
    // 경로와 파일명을 함께 세팅해주어야 하므로 마지막에 \를 붙여주어야 한다.
    String uploadPath = "C:\\dev\\myhome\\workspace\\workspace_spring_home\\backend_shop\\src\\main\\resources\\static\\upload\\";

    // 원본 파일명은 중복되면 덮어씌우므로 랜덤한 파일명으로 바꾸어 저장해준다.
    String attachedFileName = UUID.randomUUID().toString();

    // 랜덤한 파일명에 확장자를 더해주어야 한다.
    // .이 두 개 이상인 파일도 있으므로 lastIndexOf를 사용한다.
    String extension = img.getOriginalFilename().substring(img.getOriginalFilename().lastIndexOf('.'));

    // 완성된 업로드할 파일명
    attachedFileName += extension;

    // 업로드할 파일명 세팅
    File f = new File(uploadPath + attachedFileName);

    // 경로와 파일명 세팅 후 경로와 파일명을 실제 파일으로 변환
    // 실제 파일로 만들어지지 않는 예외가 많이 발생하므로 예외처리를 해주어야 한다.(경로 부재 등)
    // transferTo함수는 첨부된 파일을 우리가 만들어준 경로의 파일으로 만들어준다는 의미
    try{
      img.transferTo(f);
    } catch (Exception e){
      System.out.println(e);
    }
    // book_img 테이블에 채워줄 빈값 중 원본이미지, 참조이미지, 메인여부를 업로드 메서드에서 리턴해줄 수 있다.
    // 빈값은 bookImgDTO에 들어가면 된다.
    BookImgDTO bookImgDTO = new BookImgDTO();
    bookImgDTO.setOriginImgName(img.getOriginalFilename());
    bookImgDTO.setAttachedImgName(attachedFileName);
    // 메인이미지밖에 들어오지 않는 메서드이므로 Y를 세팅한다.
    bookImgDTO.setIsMain("Y");
    return bookImgDTO;
  }

  // 다수의 파일을 업로드할 메서드
  public static List<BookImgDTO> multipleFileUpload(MultipartFile[] subImgs){
    // 서브 이미지는 여러개가 등록되므로 빈값을 채워줄 때는 list가 적합하다.
    List<BookImgDTO> bookImgDTOList = new ArrayList<>();
    for(int i = 0 ; i < subImgs.length ; i++){
      // 서브이미지는 bookImgDTO의 리스트이다.
      // fileUpload메서드 실행 시 반환이 우리가 필요한 빈값을 채운 bookImgDTO를 반환하므로 리스트 채우기에 적합하다.
      bookImgDTOList.add(fileUpload(subImgs[i]));
      // 빈값 중 Y는 N으로 바꾸어 주어야 한다.
      bookImgDTOList.get(i).setIsMain("N");
    }
    return bookImgDTOList;
  }
}
