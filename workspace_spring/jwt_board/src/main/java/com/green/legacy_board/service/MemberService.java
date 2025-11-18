package com.green.legacy_board.service;

import com.green.legacy_board.dto.MemberDTO;
import com.green.legacy_board.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
  private final MemberMapper memberMapper;
  private final PasswordEncoder passwordEncoder;

  public void join(MemberDTO memberDTO){
    String encodePw = passwordEncoder.encode(memberDTO.getMemPw());
    memberDTO.setMemPw(encodePw);
    memberMapper.join(memberDTO);
  }

  // 로그인
  public MemberDTO getMemberInfoForLogin(String memEmail){
    return memberMapper.getMemberInfoForLogin(memEmail);
  }
}
