package com.green.legacy_board.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

// SpringSecurity의 인증과 인가에 대한 설정 파일
@Configuration
@EnableWebSecurity // springSecurity 설정 파일임을 인지
@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig {

  // 인증과 인가에 대한 설정을 세팅하는 메서드
  // 리턴타입, 매개변수는 정해져 있음.
  // 인증과 인가에 대한 설정을 spring에 객체로 넣어둠.
  @Bean
  public SecurityFilterChain filterChain (HttpSecurity http, AuthenticationConfiguration authenticationConfiguration) throws Exception {
    // 인증을 담당하는 객체를 생성
    AuthenticationManager authenticationManager =  authenticationConfiguration.getAuthenticationManager();


    http
            // 아래에 cors 설정을 위한 객체의 내용을 적용시키겠다.
            .cors(Customizer.withDefaults())
            // csrf 공격에 대한 보안 사용 해제
            .csrf(csrf -> csrf.disable())
            // 폼 태그 기반 로그인 방식 사용 안 함.
            .formLogin(form -> form.disable())
            // 에전의 로그인 방식 사용 안 됨.
            .httpBasic(basic -> basic.disable())
            // session 방식 사용 안 함.
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            // 인증 및 인가에 대한 설정.
            .authorizeHttpRequests(
                    auth ->
                            auth.anyRequest().permitAll()
            );

    // 인증 및 인가에 대한 모든 정보를 가진 http 객체를 리턴
    return http.build();
  }

  //CORS 설정 Bean
  @Bean
  public CorsConfigurationSource corsConfigurationSource() {
    CorsConfiguration config = new CorsConfiguration();
    config.setAllowCredentials(true); //쿠키 정보를 통신하기 위한 설정
    config.addAllowedOrigin("http://localhost:5173"); //리액트에서의 요청 허용
    config.addAllowedHeader("*"); //모든 헤더 정보 허용
    config.addAllowedMethod("*"); //get, post, delete, put 등의 요청 메서드 허용

    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", config);
    return source;
  }

  // 비밀번호 암호화 객체 생성 Bean
  @Bean
  public PasswordEncoder bCryptPasswordEncoder(){
    return new BCryptPasswordEncoder();
  }
}
