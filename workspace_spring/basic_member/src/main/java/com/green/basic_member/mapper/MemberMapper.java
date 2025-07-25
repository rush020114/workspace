package com.green.basic_member.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
  void insertMember();

  void updateMember();

  void deleteMember();
}
