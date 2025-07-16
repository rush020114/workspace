package com.green.restful.controller;

import org.springframework.web.bind.annotation.*;

@RestController // 객체 생성 + ???
public class TestController { // TestController testController = new TestController();
  // url 명명법 : 나타낼 자원만을 복수형으로 적고 소문자로 적고 상태를 나타내지 않게 적어라
  // url에 상태를 빼서 적어야 하지만 annotation으로 나타낼 수 있다.(GET(조회), POST(등록), DELETE(삭제), PUT(수정))

  // 회원목록조회
  // 조회이므로 GetMapping을 쓴다.
  @GetMapping("/members")
  public String getMemberList(){
    System.out.println("회원 목록을 조회합니다.");
    return "목록조회 성공";
  }

  // 회원등록
  // 등록이므로 PostMapping을 쓴다.
  @PostMapping("/members")
  public String insertMember(){
    System.out.println("회원 등록 실행");
    return "등록 성공";
  }

  // 회원수정
  // 수정이므로 PutMapping을 쓴다.
  @PutMapping("/members")
  public String updateMember(){
    System.out.println("회원 정보 수정 실행");
    return "정보 수정 성공";
  }

  // 회원삭제
  // 삭제이므로 DeleteMapping을 쓴다.
  @DeleteMapping("/members")
  public String deleteMember(){
    System.out.println("회원 삭제 실행");
    return "삭제 성공";
  }

}
