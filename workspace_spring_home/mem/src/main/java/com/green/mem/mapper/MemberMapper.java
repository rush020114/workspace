package com.green.mem.mapper;

import com.green.mem.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

  // 회원 등록
  int insertMember(MemberDTO memberDTO);
}
