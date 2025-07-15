package com.green.first;

import org.springframework.stereotype.Component;

// 클래스 간 결합도를 낮추기 위해 객체를 사용하지 않는 것을 스프링은 권장하여 객체를 대신 만들어줌.(IOC)
// component어노테이션은 클래스 위에 사용하며 사용하면 자동으로 객체를 만들어준다.
// 괄호를 없이 만들어주면 Chef chef = new Chef()처럼 객체명을 첫글자만 소문자로 자동으로 만들어준다.
// 이제 그 객체의 사용 방법(DI)를 알아야 한다.
// 일단 객체가 필요하다면 default 패키지(com.green.first : 프로젝트 생성 때 만든 패키지명)에 클래스를 형성한다.
// 그리고 객체가 필요한 클래스에 객체 생성 명령 어노테이션을 넣어준다.
@Component
public class Chef {
  public void cook(){
    System.out.println("요리");
  }
}

