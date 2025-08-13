package com.green.backend_student.controller;

import com.green.backend_student.dto.ClassDTO;
import com.green.backend_student.dto.StuDTO;
import com.green.backend_student.service.StuService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StuController {
  private StuService stuService;

  public StuController(StuService stuService){
    this.stuService = stuService;
  }

  // 학급 목록 조회 api
  @GetMapping("/classes")
  public List<ClassDTO> getClassList(){
    return stuService.getClassList();
  }

  // 학생 목록(조인 사용) 조회 api (전체를 선택했을 때)
  @GetMapping("/students")
  public List<StuDTO> getStuList(ClassDTO classDTO){
    return stuService.getStuList(classDTO);
  }

  // 학생 목록(조인 사용) 조회 api (전체가 아닌 것을 선택했을 때)
  @GetMapping("/students/{classNum}")
  public List<StuDTO> getStuListOther(@PathVariable("classNum") int classNum, ClassDTO classDTO){
    classDTO.setClassNum(classNum);
    return stuService.getStuList(classDTO);
  }
}
