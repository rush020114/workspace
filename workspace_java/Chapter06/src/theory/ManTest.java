package theory;

public class ManTest {
  public static void main(String[] args){
    // 상속을 사용하는 이유 : 코드의 재활용성을 높인다. 중복되는 변수나 메서드를 다시 입력할 필요가 없다.
    // 자식 클래스의 객체를 생성하면 부모 클래스도 자동으로 객체가 생성된다.
    BusinessMan businessMan = new BusinessMan("그린");

    businessMan.tellName(); // 상속을 사용함으로써 Man 클래스의 멤버변수도, 메서드도 사용할 수 있다.

    System.out.println(businessMan.name);
  }
}
