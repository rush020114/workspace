package com.green.basic_member.mapper;

import com.green.basic_member.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
  int insertMember(MemberDTO memberDTO);

  int updateMember(MemberDTO memberDTO);

  int deleteMember(String memId);
}
