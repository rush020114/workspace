package com.green.basic_member.controller;

import com.green.basic_member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {
  private MemberService memberService;

  @Autowired
  public MemberController(MemberService memberService){
    this.memberService = memberService;
  }

  @PostMapping("/members")
  public void insertMember(){
    memberService.insertMember();
  }

  @PutMapping("/members")
  public void updateMember(){
    memberService.updateMember();
  }

  @DeleteMapping("/members")
  public void deleteMember(){
    memberService.deleteMember();
  }
}
