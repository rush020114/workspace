package com.green.legacy_board.controller;

import com.green.legacy_board.dto.MemberDTO;
import com.green.legacy_board.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Enumeration;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {
  private final MemberService memberService;

  // 회원가입 실행
  @PostMapping("")
  public ResponseEntity<?> join(@RequestBody MemberDTO memberDTO){

    memberService.join(memberDTO);

    return ResponseEntity
            .status(HttpStatus.CREATED)
            .build();
  }
}
