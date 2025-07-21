package com.green.rest_test.controller;

import com.green.rest_test.dto.StudentDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
  @PostMapping("students")
  public String insertStudent(@RequestBody StudentDTO studentDTO){
    System.out.println(studentDTO);
    return "등록완료";
  }
}
