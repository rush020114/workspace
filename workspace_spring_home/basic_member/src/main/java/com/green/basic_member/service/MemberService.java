package com.green.basic_member.service;

import com.green.basic_member.dto.MemberDTO;
import com.green.basic_member.mapper.MemberMapper;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
  private MemberMapper memberMapper;

  public MemberService(MemberMapper memberMapper){
    this.memberMapper = memberMapper;
  }

  public int insertMember(MemberDTO memberDTO){
    return memberMapper.insertMember(memberDTO);
  }

  public int updateMember(MemberDTO memberDTO){
    return memberMapper.updateMember(memberDTO);
  }

  public int deleteMember(String memId){
    return memberMapper.deleteMember(memId);
  }
}
