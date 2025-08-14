package com.green.backend_shop.member.controller;

import com.green.backend_shop.member.dto.MemberDTO;
import com.green.backend_shop.member.service.MemberService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/members")
public class MemberController {
  private MemberService memberService;

  public MemberController(MemberService memberService){
    this.memberService = memberService;
  }

  // 회원 등록 api
  @GetMapping("")
  public int insertMember(@RequestBody MemberDTO memberDTO){
    return memberService.insertMember(memberDTO);
  }
}
