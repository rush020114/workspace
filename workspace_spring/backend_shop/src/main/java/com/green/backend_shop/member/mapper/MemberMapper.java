package com.green.backend_shop.member.mapper;

import com.green.backend_shop.member.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

  // 회원가입
  void join(MemberDTO memberDTO);

  // 아이디 중복확인
  String checkMemId(String memId);
}