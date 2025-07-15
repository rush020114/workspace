package com.green.first;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

// 응집도 :
// 1. 하나의 클래스 내에 클래스가 담당하는 모든 기능이 완벽하게 구현되어야 함
// 2. 핵심 기능 구현 시 사전, 사후 작업에 신경쓰지 않고, 핵심기능만 구현하는 것!
// 결합도 :
// 1. 서로 다른 두 클래스가 강하게 연결되어 있는 경우
@RestController
public class TestController {
  // 해당 메서드 실행 : localhost:8080/t1
  @GetMapping("/t1")
  public String test1(){
    return "test1() 메서드 실행";
  }

  @GetMapping("/t2")
  public int test2(){
    return 5;
  }

  @GetMapping("/t3")
  public int[] test3(){
    return new int[] {1, 2, 3};
  }

  @GetMapping("/t4")
  public Student test4(){
    return new Student("홍", 80, 90);
  }

  @GetMapping("/t5")
  public List<Student> test5(){
    List<Student> stuList = new ArrayList<>();
    stuList.add(new Student("kim", 70, 90));
    stuList.add(new Student("lee", 80, 100));
    stuList.add(new Student("park", 75, 95));
    return stuList;
  }
}
