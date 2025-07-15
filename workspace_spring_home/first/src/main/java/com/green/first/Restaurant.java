package com.green.first;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Restaurant {
  private Chef chef;

  // 의존성 주입은 민들어진 객체를 필요한 객체에 넣어준다.
  // autowired는 생성자 의존성 주입을 실행한다.
  // 자동으로 만들어진 객체를 자동으로 연결한다.
  @Autowired
  // 프로젝트가 런되면서 component를 보면 지동으로 그 클래스의 객체를 만든다.
  // 그리고 생성자에 autowired가 있으면 매개변수를 보고 자동으로 만들어져 있는 객체를 자동으로 넣는다.
  // 그 변수를 멤버변수에 넣음으로써 멤버변수의 객체가 생성된다.
  // 이로써 객체를 만들지 않고 생성이 가능해진다.
  public Restaurant(Chef chef){
    this.chef = chef;
  }

  public void open(){
    chef.cook();
  }
}
