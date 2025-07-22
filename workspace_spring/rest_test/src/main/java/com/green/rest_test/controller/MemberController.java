package com.green.rest_test.controller;

import com.green.rest_test.dto.MemberDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {
  @PostMapping("/members")
  public String insertMember(@RequestBody MemberDTO memberDTO){
    System.out.println(memberDTO);
    return "하나의 회원 등록 완료";
  }
}
