package com.green.mem.controller;

import com.green.mem.dto.MemberDTO;
import com.green.mem.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("members")
public class MemberController {
  private MemberService memberService;

  public MemberController(MemberService memberService){
    this.memberService = memberService;
  }

  // 회원 등록
  public int insertMember(MemberDTO memberDTO){
    return memberService.insertMember(memberDTO);
  }
}
