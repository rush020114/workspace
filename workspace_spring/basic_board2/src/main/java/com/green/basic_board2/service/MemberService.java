package com.green.basic_board2.service;

import com.green.basic_board2.dto.BoardDTO;
import com.green.basic_board2.dto.MemberDTO;
import com.green.basic_board2.mapper.MemberMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
  MemberMapper memberMapper;

  public MemberService(MemberMapper memberMapper){
    this.memberMapper = memberMapper;
  }

  public int insertMember(MemberDTO memberDTO){
    return memberMapper.insertMember(memberDTO);
  }

  public String getMemberName(){
    return memberMapper.getMemberName();
  }

  public List<String> getMemberNameAll(){
    return memberMapper.getMemberNameAll();
  }

  public List<MemberDTO> getMemberAll(){
    return memberMapper.getMemberAll();
  }
}
