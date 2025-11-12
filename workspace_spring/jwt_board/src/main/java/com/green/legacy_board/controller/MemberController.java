package com.green.legacy_board.controller;

import com.green.legacy_board.dto.MemberDTO;
import com.green.legacy_board.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Enumeration;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {
  private final MemberService memberService;

  // 회원가입 실행
  @PostMapping("")
  public ResponseEntity<?> join(@RequestBody MemberDTO memberDTO){

    memberService.join(memberDTO);

    return ResponseEntity
            .status(HttpStatus.CREATED)
            .build();
  }

  // 로그인 검증
  // 실제 로그인(로그인 가능한 회원이면 로그인 정보를 세션에 저장
  @PostMapping("/login")
  public String login(@ModelAttribute MemberDTO memberDTO, HttpSession httpSession){

    // 로그인 하기 전 세션 데이터 조회
    Enumeration<String> names = httpSession.getAttributeNames();
    System.out.println(" === 로그인 전 세션에 저장된 데이터 ===");
    while(names.hasMoreElements()){
      String name = names.nextElement();
      Object  value = httpSession.getAttribute(name);
      System.out.println("key : " + name + " / value : " + value);
    }

    System.out.println(memberDTO);
    MemberDTO result = memberService.login(memberDTO);
    // 실제 로그인(로그인 가능한 회원이면 로그인 정보를 세션에 저장)
    if(result != null){
      httpSession.setAttribute("loginInfo", result);

      // 로그인 후 세션 데이터 조회
      Enumeration<String> keys = httpSession.getAttributeNames();
      System.out.println(" === 로그인 후 세션에 저장된 데이터 ===");
      while(keys.hasMoreElements()){
        String name = keys.nextElement();
        Object  value = httpSession.getAttribute(name);
        System.out.println("key : " + name + " / value : " + value);
      }
    }

    return "redirect:/boards";
  }

  // 로그아웃
  @GetMapping("/logout")
  public String logout(HttpSession httpSession){
    httpSession.removeAttribute("loginInfo");

    return "redirect:/boards";
  }
}
