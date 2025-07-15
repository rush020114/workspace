package com.green.first;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
  @GetMapping("/t1")
  public String test1(){
    return "test1() 메서드 실행";
  }
}
