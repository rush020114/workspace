package com.green.backend_shop.member.controller;

import com.green.backend_shop.member.dto.MemberDTO;
import com.green.backend_shop.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {
  private final MemberService memberService;

  // 회원가입 api
  @PostMapping("")
  public void join(@RequestBody MemberDTO memberDTO){
    System.out.println(memberDTO);
    memberService.join(memberDTO);
  }

  // 아이디 사용가능 여부 판단 api
  @GetMapping("/check-id/{memId}")
  public boolean checkId(@PathVariable("memId") String memId){
    // 사용가능 : return true, 사용불가능 : return false
    return memberService.isUsableId(memId);
  }
}