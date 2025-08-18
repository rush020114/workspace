package com.green.backend_shop.member.mapper;

import com.green.backend_shop.member.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
  // 회원가입 실행 쿼리
  void join(MemberDTO memberDTO);

  // 아이디 중복확인 쿼리 실행
  String checkId(String memId);
}
