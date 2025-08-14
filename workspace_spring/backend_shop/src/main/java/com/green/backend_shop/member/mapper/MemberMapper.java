package com.green.backend_shop.member.mapper;

import com.green.backend_shop.member.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

  // 회원 등록
  int insertMember(MemberDTO memberDTO);
}
