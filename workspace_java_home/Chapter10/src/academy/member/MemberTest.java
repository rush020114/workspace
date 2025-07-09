package academy.member;

import java.util.ArrayList;
import java.util.List;

public class MemberTest {
  public static void main(String[] args){
    List<Member> memberList = new ArrayList<>();

    memberList.add(new Member("java", "1111", "김", 21));
    memberList.add(new Member("python", "2222", "이", 22));
    memberList.add(new Member("c++", "3333", "박", 23));

    int sum = 0;
    for(Member member : memberList){
      System.out.println(member);
      sum += member.getAge();
    }
    System.out.println("멤버의 나이 : " + sum);

    for(int i = 0 ; i < memberList.size() ; i++){
      if(memberList.get(i).getId().equals("java")){
        memberList.remove(i);
      }
    }
    System.out.println(memberList.size());
  }
}
