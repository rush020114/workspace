package apple;

// 접근제한자 : 변수나 메서드의 사용 범위를 지정하는 문법
// 접근제한자의 종류 : private < default < protected < public
// private : 변수, 메서드를 선언한 클래스 내에서만 접근 가능!
// default : 같은 패키지 내에서만 접근 가능함.
// public : 같은 프로젝트 내의 모든 곳에서 사용 가능!
// 멤버변수는 무조건 private 붙인다!
// 메서드는 무조건 public 쓴다.
// 지역변수에는 접근제한자를 사용 못함.
// 클래스에는 public, default만 사용 가능!
public class Apple {
  public String name;
  private int price;
  double avg;

  public void setPrice(int price){
    this.price = price < 0 ? 0 : price;
  }

  public void aaa(){
    price = 10;
  }
  private void bbb(){}
  void ccc(){}
}
