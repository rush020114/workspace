package com.green.backend_shop.member.service;

import com.green.backend_shop.member.dto.MemberDTO;
import com.green.backend_shop.member.mapper.MemberMapper;
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
