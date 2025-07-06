package book.inheritance2;

// 상속 : 부모클래스로부터 멤버변수와 메서드를 물려받는다.
// 상속문법 : class 자식클래스 extends 부모클래스{}
public class UniversityStudent extends Student {
  String major;

  public String getMajor() {
    return major;
  }

  public void setMajor(String major) {
    this.major = major;
  }

  public void printInfo(){
    System.out.println(name + "(" + major + ")의 점수 : " + score);
  }
}
