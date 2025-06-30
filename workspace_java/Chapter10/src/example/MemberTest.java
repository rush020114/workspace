package example;

import java.util.ArrayList;
import java.util.List;

public class MemberTest {
  public static void main(String[] args){
    List<Member> memberList = new ArrayList<>();

    memberList.add(new Member("java", "pw1", "java1", 20));
    memberList.add(new Member("javascript", "pw2", "javascript1", 21));
    memberList.add(new Member("python", "pw3", "python1", 22));
    memberList.add(new Member("c++", "pw4", "c++1", 23));
    memberList.add(new Member("java", "pw5", "java1", 24));

    for(Member e : memberList){
      System.out.println(e);
    }

    int sum = 0;
    for(Member e : memberList){
      sum += e.getAge();
    }
    System.out.println(sum);

    for(int i = 0 ; i < memberList.size() ; i++){
      if(memberList.get(i).getId().equals("java")){
        memberList.remove(i);
      }
    }
    System.out.println(memberList);
  }
}
