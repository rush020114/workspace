package com.green.mem.question.controller;

import com.green.mem.question.dto.QuestionDTO;
import com.green.mem.question.dto.QuestionImgDTO;
import com.green.mem.question.service.QuestionService;
import com.green.mem.util.QuestionUploadUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/questions")
public class QuestionController {
  private final QuestionService questionService;

  // 문의 등록
  @PostMapping("")
  public void regQst(@RequestParam(name = "mainImg", required = false) MultipartFile mainImg
                     , @RequestParam(name = "subImgs", required = false) MultipartFile[] subImgs
                     , QuestionDTO questionDTO){

    List<QuestionImgDTO> questionImgDTOList = new ArrayList<>();

    // 메인 이미지가 있을 때만 업로드
    if (mainImg != null && !mainImg.isEmpty()) {
      QuestionImgDTO questionImgDTO = QuestionUploadUtil.questionUpload(mainImg);
      questionImgDTOList.add(questionImgDTO);
    }

    // 서브 이미지가 있을 때만 업로드
    if (subImgs != null && subImgs.length > 0) {
      questionImgDTOList.addAll(QuestionUploadUtil.multipleQuestionUpload(subImgs));
    }

    questionService.regQst(questionDTO, questionImgDTOList);

  }

  // 이용자 문의 목록 조회
  @GetMapping("")
  public List<QuestionDTO> getQstList(QuestionDTO questionDTO){
    return questionService.getQstList(questionDTO);
  }

  // 문의 상세 조회 및 답변
  @GetMapping("/detail")
  public QuestionDTO getQstDetail(QuestionDTO questionDTO){
    log.info(questionDTO.toString());
    return questionService.getQstDetail(questionDTO);
  }

  // 문의 삭제
  @DeleteMapping("/{qstId}")
  public void deleteQst(@PathVariable("qstId") int qstId){
    questionService.deleteQst(qstId);
  }

  // 문의 수정
  @PutMapping("/{qstId}")
  public void updateQst(@PathVariable("qstId") int qstId, @RequestBody QuestionDTO questionDTO){
    questionDTO.setQstId(qstId);
    questionService.updateQst(questionDTO);
  }
}
