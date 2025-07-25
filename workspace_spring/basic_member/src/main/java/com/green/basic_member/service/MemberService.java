package com.green.basic_member.service;

import com.green.basic_member.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
  private MemberMapper memberMapper;

  @Autowired
  public MemberService(MemberMapper memberMapper){
    this.memberMapper = memberMapper;
  }

  public void insertMember(){
    memberMapper.insertMember();
  }

  public void updateMember(){
    memberMapper.updateMember();
  }

  public void deleteMember(){
    memberMapper.deleteMember();
  }
}
