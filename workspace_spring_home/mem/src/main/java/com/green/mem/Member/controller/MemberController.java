package com.green.mem.Member.controller;

import com.green.mem.Member.dto.MemberDTO;
import com.green.mem.Member.service.MemberService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/members")
public class MemberController {
  private MemberService memberService;

  public MemberController(MemberService memberService){
    this.memberService = memberService;
  }

  // 회원 등록
  @PostMapping("")
  public int insertMember(@RequestBody MemberDTO memberDTO){
    return memberService.insertMember(memberDTO);
  }

  // 중복 확인
  @GetMapping("/{memId}")
  public boolean isUsable(@PathVariable("memId") String memId){
    return memberService.isUsable(memId);
  }

  // 로그인 api
  @GetMapping("")
  public MemberDTO login (MemberDTO memberDTO){
    return memberService.login(memberDTO);
  }
}
