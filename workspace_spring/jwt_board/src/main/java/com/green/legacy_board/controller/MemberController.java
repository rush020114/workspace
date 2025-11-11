package com.green.legacy_board.controller;

import com.green.legacy_board.dto.MemberDTO;
import com.green.legacy_board.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Enumeration;

@Controller
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

  private final MemberService memberService;

  @GetMapping("/join")
  public String goJoin(){
    return "join";
  }

  // 회원가입 실행
  @PostMapping("/join")
  public String join(@ModelAttribute MemberDTO memberDTO){

    System.out.println(memberDTO);

    memberService.join(memberDTO);

    // 회원 가입 후 바로 board-list.html 파일로 이동하면 게시글 목록 조회 안 됨.
    // -> 게시글 목록 조회 기능을 수행하는 controller의 메서드를 실행
    // return 안의 내용은 기본적으로 html 파일명으로 인식
    // -> redirect: 키워드를 붙이면 html파일명으로 해석하지 않음.
    return "redirect:/boards";
  }

  // 로그인 페이지 이동
  @GetMapping("/login")
  public String goLogin(){
    return "login";
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
