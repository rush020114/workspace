package yoon;

class InstNum{
  static int instNum = 0; // 멤버변수 (static 변수)

  InstNum(){
    instNum++; // 생성자로 static 멤버변수 초기화(잘못된 방법)
    System.out.println("인스턴스 생성 : " + instNum);
  }
}
public class ClassVar {
  public static void main(String[] args) {
    InstNum cnt1 = new InstNum(); // 공용변수를 출력하므로 객체 개인이 출력하는 문법이 틀렸진 않았지만 해석이 이상함.
    InstNum cnt2 = new InstNum();
    InstNum cnt3 = new InstNum();
  }

}
