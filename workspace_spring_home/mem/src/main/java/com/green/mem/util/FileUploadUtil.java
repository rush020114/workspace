package com.green.mem.util;

import com.green.mem.clothing.dto.ClothingImgDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FileUploadUtil {

  // 메인 이미지 업로드 및 옷 이미지 쿼리 빈값 리턴 메서드
  public static ClothingImgDTO fileUpload(MultipartFile img){
    String uploadPath = "C:\\dev\\myhome\\workspace\\workspace_spring_home\\mem\\src\\main\\resources\\upload\\";

    String attachedFileName = UUID.randomUUID().toString();

    String extension = img.getOriginalFilename().substring(img.getOriginalFilename().lastIndexOf('.'));

    attachedFileName += extension;

    File file = new File(uploadPath + attachedFileName);

    try {
      img.transferTo(file);
    } catch (Exception e){
      System.out.println(e);
    }

    ClothingImgDTO clothingImgDTO = new ClothingImgDTO();
    clothingImgDTO.setOriginImgName(img.getOriginalFilename());
    clothingImgDTO.setAttachedImgName(attachedFileName);
    clothingImgDTO.setIsMain("Y");
    return clothingImgDTO;
  }

  // 서브 이미지들 업로드 및 옷 이미지 쿼리 빈값 리턴 메서드
  public static List<ClothingImgDTO> multipleFileUpload(MultipartFile[] subImgs){
    List<ClothingImgDTO> clothingImgDTOList = new ArrayList<>();

    for(int i = 0 ; i < subImgs.length ; i++){
      clothingImgDTOList.add(fileUpload(subImgs[i]));
      clothingImgDTOList.get(i).setIsMain("N");
    }

    return clothingImgDTOList;
  }
}
