package com.green.legacy_board.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {

  @GetMapping("/test1")
  public String test1(){
    System.out.println("test1 메서드 실행");
    return "test1";
  }

  @PreAuthorize("isAuthenticated()")
  @GetMapping("/test2")
  public String test2(){
    System.out.println("test2 메서드 실행");
    return "test2";
  }

  @PreAuthorize("hasRole('USER')")
  @GetMapping("/test3")
  public String test3(){
    System.out.println("test3 메서드 실행");
    return "test3";
  }

}
