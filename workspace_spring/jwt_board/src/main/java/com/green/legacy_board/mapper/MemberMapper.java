package com.green.legacy_board.mapper;

import com.green.legacy_board.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
  void join(MemberDTO memberDTO);

  // 로그인
  MemberDTO getMemberInfoForLogin(String memEmail);
}
