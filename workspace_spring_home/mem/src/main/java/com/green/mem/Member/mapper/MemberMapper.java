package com.green.mem.Member.mapper;

import com.green.mem.Member.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

  // 회원 등록
  int insertMember(MemberDTO memberDTO);

  // 중복 확인
  String isDup(String memId);

  // 로그인
  MemberDTO login(MemberDTO memberDTO);
}
