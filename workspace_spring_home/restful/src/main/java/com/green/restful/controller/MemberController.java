package com.green.restful.controller;

import com.green.restful.dto.MemberDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {
  @PostMapping("/members")
  public String insertMember(@RequestBody MemberDTO memberDTO){
    System.out.println(memberDTO);
    return "목록조회 성공";
  }
}
