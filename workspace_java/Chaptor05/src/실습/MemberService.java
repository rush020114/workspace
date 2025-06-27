package 실습;

public class MemberService {
  private String id;
  private String password;

  public boolean login(String id, String password){
      boolean trueFalse = id.equals("hong") && password.equals("12345");
      return trueFalse;
  }

  public void logout(String id){
    System.out.println("로그아웃 되었습니다.");
  }
}
