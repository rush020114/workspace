package com.green.basic_board2.controller;

import com.green.basic_board2.dto.MemberDTO;
import com.green.basic_board2.service.MemberService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

  @GetMapping("/test1")
  public String getMemberName(){
    return memberService.getMemberName();
  }

  @GetMapping("/test2")
  public List<String> getMemberNameAll(){
    return memberService.getMemberNameAll();
  }

  @GetMapping("/test3")
  public List<MemberDTO> getMemberAll(){
    return memberService.getMemberAll();
  }
}
