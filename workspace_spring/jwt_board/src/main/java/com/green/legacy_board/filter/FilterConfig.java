package com.green.legacy_board.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// @Configuration : 객체 생성 + 설정 파일
// @Bean : 메서드의 정의문에 사용하며, 리턴되는 데이터를 객체로 만들어줌
@Configuration
public class FilterConfig {

  // 객체를 계속 생성하지 않고 하나만 생성해서 의존성을 주입하여 시스템 부담을 줄인다.
  /*@Bean
  public FilterRegistrationBean<Filter1> myFilterRegistration(){
    FilterRegistrationBean<Filter1> registrationBean = new FilterRegistrationBean<>();

    registrationBean.setFilter(new Filter1());
    registrationBean.addUrlPatterns("/*");
    registrationBean.setOrder(0);

    return registrationBean;
  }

  @Bean
  public FilterRegistrationBean<Filter2> myFilterRegistration1(){
    FilterRegistrationBean<Filter2> registrationBean = new FilterRegistrationBean<>();

    registrationBean.setFilter(new Filter2());
    registrationBean.addUrlPatterns("/member/*");
    registrationBean.setOrder(1);

    return registrationBean;
  }*/
}
