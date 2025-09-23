package com.green.todo_list.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// cors 설정 : react, react native에서 spring으로의 접근을 허용하는 설정
// 통상적으로 spring(백엔드)에서 작업한다.

// configuration 어노테이션 : 객체 생성 + 해당 파일이 설정 파일임을 인지
// 현재 클래스는 WebMvcConfigurer의 인터페이스를 구현 중
// WebMvcConfigurer 인터페이스는 addCorsMapping 메서드가 존재
// addCorsMappings 메서드에서 cors 설정 추가

@Configuration
public class WebConfig implements WebMvcConfigurer {

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**") // 접근 허용할 spring api url (*이 두 개면 / 다음 모든 것까지도 허용)
            .allowedOrigins("http:/localhost:5173", "http://localhost:8081", "exp://192.168.204.69:8081") // 접근 허용할 server(react와, react native)
            .allowedMethods("GET", "POST", "PUT", "DELETE")
            .allowedHeaders("*") // 허용할 헤더 정보
            .allowCredentials(false); // 로그인 방식에 따른 boolean값 설정(토큰)
  }
}