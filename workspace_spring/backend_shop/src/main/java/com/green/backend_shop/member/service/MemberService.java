package com.green.backend_shop.member.service;

import com.green.backend_shop.member.dto.MemberDTO;
import com.green.backend_shop.member.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor // 요구되는(final을 가진 멤버변수) 매개변수를 가진 생성자
// 개발은 객체의 주소값이 바뀌는 경우가 거의 없다. 중간에 값이 바뀌는 것을 방지하기 위해 final을 쓴다.
public class MemberService {
  private final MemberMapper memberMapper;

  // 회원가입
  public void join(MemberDTO memberDTO){
    memberMapper.join(memberDTO);
  }

  // 아이디 사용가능 여부 확인
  // 사용가능 : return true, 사용불가능 : return false
  public boolean isUsableId(String memId){
    // 조회된 데이터가 없으면 null => 사용 가능한 id
    String selectedId = memberMapper.checkMemId(memId);
    return selectedId == null;
  }
}