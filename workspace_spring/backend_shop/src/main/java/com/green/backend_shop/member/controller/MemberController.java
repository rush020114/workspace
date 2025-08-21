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

  // 로그인 api
  // get방식은 주로 리액트에서 하나의 데이터가 넘어온다.
  // get방식 사용 중 종종 리액트에서 넘어오는 데이터가 여러 개인 경우가 있다.
  // 리액트에서 작업해준 방식을 어노테이션 없이 dto로 받으면 된다.
  @GetMapping("/login")
  public MemberDTO login(MemberDTO memberDTO){
    return memberService.login(memberDTO);
  }

}