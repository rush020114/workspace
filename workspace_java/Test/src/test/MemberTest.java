package test;

public class MemberTest {
  public static void main(String[] args){
    Member member = new Member();

    member.setInfo("java", "1234", "kim", 20);
    member.showInfo();
    member.isLogin("java", "1234");
    member.isLogin("java", "1111");

    System.out.println(member.isLogin("java", "1234") ? "로그인 가능" : "로그인 불가능");
  }
}
