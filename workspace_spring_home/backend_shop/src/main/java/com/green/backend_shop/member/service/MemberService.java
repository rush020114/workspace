package com.green.backend_shop.member.service;

import com.green.backend_shop.member.dto.MemberDTO;
import com.green.backend_shop.member.mapper.MemberMapper;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
  private MemberMapper memberMapper;

  public MemberService(MemberMapper memberMapper){
    this.memberMapper = memberMapper;
  }

  // 회원가입
  public void join(MemberDTO memberDTO){
    memberMapper.join(memberDTO);
  }

  // 아이디 사용 가능 여부 확인
  // 사용 가능 : return true
  // mapper랑 service의 메서드를 다르게 만들 때도 있다.
  public boolean isUsableId(String memId){
    // 조회된 데이터가 없으면 null이다.(memberMapper의 return은 조회한 아이디)
    return memberMapper.checkId(memId) == null;
  }
}
