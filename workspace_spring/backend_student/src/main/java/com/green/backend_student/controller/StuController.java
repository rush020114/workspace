package com.green.backend_student.controller;

import com.green.backend_student.dto.ClassDTO;
import com.green.backend_student.dto.StuDTO;
import com.green.backend_student.service.StuService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StuController {
  private StuService stuService;

  public StuController(StuService stuService){
    this.stuService = stuService;
  }

  // 모든 학급명 조회 api
  @GetMapping("/classes")
  public List<ClassDTO> getClassInfo(){
    return stuService.getClassInfo();
  }

  // 모든 반의 학생 목록 조회 api
  @GetMapping("/students")
  public List<StuDTO> getStudentInfo(){
    return stuService.getStudentInfo();
  }

  // 선택된 학생 목록 조회 api
  @GetMapping("/students/{classNum}")
  public List<StuDTO> getStudent(@PathVariable("classNum") int classNum){
    return stuService.getStudent(classNum);
  }
}
