package com.green.basic_board2.controller;

import com.green.basic_board2.dto.MemberDTO;
import com.green.basic_board2.service.MemberService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {
  MemberService memberService;

  public MemberController(MemberService memberService){
    this.memberService = memberService;
  }

  @PostMapping("/members")
  public int insertMember(@RequestBody MemberDTO memberDTO){
    System.out.println(memberDTO);
    return memberService.insertMember(memberDTO);
  }
}
