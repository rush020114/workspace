package com.green.legacy_student.controller;

import com.green.legacy_student.service.StuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class StuController {
  private final StuService stuService;

  @GetMapping("")
  public String main(){
    return "stu-list";
  }
}
