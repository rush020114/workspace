package com.green.basic_board2.mapper;

import com.green.basic_board2.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {
  int insertMember(MemberDTO memberDTO);

  // 쿼리를 실행시킬 인터페이스의 조회 추상메서드 리턴타입은 받아올 모든 데이터의 자료형으로 한다.
  String getMemberName();

  List<String> getMemberNameAll();

  int getMemberAge();

  MemberDTO getMember();

  List<MemberDTO> getMemberAll();

  List<MemberDTO> getMemberAll2(int memAge);
}
