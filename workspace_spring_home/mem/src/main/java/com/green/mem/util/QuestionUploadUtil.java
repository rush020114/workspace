package com.green.mem.util;

import com.green.mem.question.dto.QuestionImgDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class QuestionUploadUtil {
  // 메인 이미지 업로드 및 이미지 쿼리 빈값 메서드
  public static QuestionImgDTO questionUpload(MultipartFile questionImg){
    String uploadPath = "C:\\dev\\myhome\\workspace\\workspace_spring_home\\mem\\src\\main\\resources\\static\\answer_upload\\";

    String attachedFileName = UUID.randomUUID().toString();

    String extension = questionImg.getOriginalFilename().substring(questionImg.getOriginalFilename().lastIndexOf('.'));

    attachedFileName += extension;

    File file = new File(uploadPath + attachedFileName);

    try {
      questionImg.transferTo(file);
    } catch (Exception e) {
      System.out.println(e);
    }

    QuestionImgDTO questionImgDTO = new QuestionImgDTO();
    questionImgDTO.setOriginImgName(questionImg.getOriginalFilename());
    questionImgDTO.setAttachedImgName(attachedFileName);
    questionImgDTO.setIsMain("Y");

    return questionImgDTO;
  }

  // 서브 이미지들 업로드 및 이미지 쿼리 빈값 리턴 메서드
  public static List<QuestionImgDTO> multipleQuestionUpload(MultipartFile[] questionSubImgs){
    List<QuestionImgDTO> questionImgDTOList = new ArrayList<>();

    for(int i = 0 ; i < questionSubImgs.length ; i++){
      questionImgDTOList.add(questionUpload(questionSubImgs[i]));
      questionImgDTOList.get(i).setIsMain("N");
    }

    return questionImgDTOList;
  }
}
