package com.green.backend_shop.member.controller;

import com.green.backend_shop.member.dto.MemberDTO;
import com.green.backend_shop.member.service.MemberService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("members")
public class MemberController {
  private MemberService memberService;

  public MemberController(MemberService memberService){
    this.memberService = memberService;
  }

  //회원가입 api
  @PostMapping("")
  public void join(@RequestBody MemberDTO memberDTO){
    memberService.join(memberDTO);
  }

  // id 사용 가능 여부 판단 api
  @GetMapping("/check-id/{memId}")
  public boolean checkId(@PathVariable("memId") String memId){
    // 사용 가능 : return true
    return memberService.isUsableId(memId);
  }

  // 로그인
  // 로그인 가능 쿼리를 실행할 땐 get으로 데이터를 두 개 받아야 하는 상황이 생긴다.
  // react에서 작업을 다 해주었기 떄문에 spring에선 어노테이션 없이 dto를 생성해 받으면 된다.
  @GetMapping("/login")
  public MemberDTO login(MemberDTO memberDTO){
    return memberService.login(memberDTO);
  }

}
