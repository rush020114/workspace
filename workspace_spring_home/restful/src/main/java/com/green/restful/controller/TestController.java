package com.green.restful.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
  @PostMapping("/members")
  public String insertMember(){
    System.out.println("회원 목록 조회");
    return "목록조회 성공";
  }
}
