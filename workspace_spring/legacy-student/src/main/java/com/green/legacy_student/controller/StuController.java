package com.green.legacy_student.controller;

import com.green.legacy_student.dto.StuDTO;
import com.green.legacy_student.service.StuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class StuController {
  private final StuService stuService;

  @GetMapping("")
  public String main(Model model){
    // 학급 목록 데이터 조회
    model.addAttribute("classList", stuService.getClassList());

    // 학생 목록 데이터 조회
    model.addAttribute("stuList", stuService.getStuList());

    return "stu-list";
  }

  // 반 선택하면 학생 목록 다시 조회
  @GetMapping("/getStuListAgain/{classNum}")
  public String getStuListAgain(@PathVariable("classNum") int classNum, Model model){

    // 학급 목록 데이터 조회
    model.addAttribute("classList", stuService.getClassList());

    model.addAttribute("stuList", stuService.getStuListAgain(classNum));

    return "stu-list";
  }

  // 반 선택하면 학생 목록 다시 조회
  @ResponseBody // 이 메서드는 비동기 처리 메서드임을 인식
  @GetMapping("/getStuListAgain2/{classNum}")
  public List<StuDTO> getStuListAgain2(@PathVariable("classNum") int classNum){

    return stuService.getStuListAgain(classNum);
  }

  @ResponseBody
  @GetMapping("/getStuDetail/{stuNum}")
  public StuDTO getStuDetail(@PathVariable("stuNum") int stuNum){
    return stuService.getStuDetail(stuNum);
  }

}
