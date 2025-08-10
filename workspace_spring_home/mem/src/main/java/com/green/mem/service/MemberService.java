package com.green.mem.service;

import com.green.mem.dto.MemberDTO;
import com.green.mem.mapper.MemberMapper;
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
}
