package com.green.mem.Member.service;

import com.green.mem.Member.dto.MemberDTO;
import com.green.mem.Member.mapper.MemberMapper;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
  private MemberMapper memberMapper;

  public MemberService(MemberMapper memberMapper){
    this.memberMapper = memberMapper;
  }

  // 회원 등록
  public int insertMember(MemberDTO memberDTO){
    return memberMapper.insertMember(memberDTO);
  }

  // 중복 확인
  public boolean isUsable(String memId){
    return memberMapper.isDup(memId) == null;
  }

  // 로그인
  public MemberDTO login (MemberDTO memberDTO){
    return memberMapper.login(memberDTO);
  }
}
