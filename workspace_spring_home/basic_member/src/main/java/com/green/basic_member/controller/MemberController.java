package com.green.basic_member.controller;

import com.green.basic_member.dto.MemberDTO;
import com.green.basic_member.service.MemberService;
import org.springframework.web.bind.annotation.*;

@RestController
public class MemberController {
  private MemberService memberService;

  public MemberController(MemberService memberService){
    this.memberService = memberService;
  }

  @PostMapping("/members")
  public int insertMember(@RequestBody MemberDTO memberDTO){
    return memberService.insertMember(memberDTO);
  }

  @PutMapping("/members/{memId}")
  public int updateMember(@RequestBody MemberDTO memberDTO, @PathVariable("memId") String memId){
    memberDTO.setMemId(memId);
    return memberService.updateMember(memberDTO);
  }

  @DeleteMapping("/members/{memId}")
  public int deleteMember(@PathVariable("memId") String memId){
    return memberService.deleteMember(memId);
  }
}
