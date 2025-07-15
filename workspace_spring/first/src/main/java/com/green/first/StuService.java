package com.green.first;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// Component 어노테이션은 객체 생성을 해준다.
@Component
public class StuService {
  private Member member;

  // 생성자 의존성 주입
  @Autowired // 자동으로 객체를 연결하겠습니다.
  public StuService(Member m){
    this.member = m;
  }

}
