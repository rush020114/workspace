package test;

public class Member {
  private String id;
  private String pw;
  private String name;
  private int age;

  public Member(){
  }

  public void setInfo(String id, String pw, String name, int age){
    this.id = id;
    this.pw = pw;
    this.name = name;
    this.age = age;
  }

  public void showInfo(){
    System.out.println("아이디: " + id);
    System.out.println("비밀번호: " + pw);
    System.out.println("이름: " + name);
    System.out.println("나이: " + age);
  }

  public boolean isLogin(String id, String pw){
    return this.id.equals(id) && this.pw.equals(pw);
  }
}
