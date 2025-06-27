package 실습;

public class MemberServiceExample {
  public static void main(String[] args){
    MemberService membersevice = new MemberService();
    boolean result = membersevice.login("hong", "12345");
    if(result){
      System.out.println("로그인 되었습니다.");
      membersevice.logout("hong");
    }

    else{
      System.out.println("id 또는 password가 올바르지 않습니다.");
    }
  }
}
