package 이론;

// static : 공용 변수, 메서드
// 객체가 각각 가지는 변수가 아닌, 모든 객체가 공용으로 사용하는 변수.
// static이 붙은 변수, 메서드는 객체 생성 전에 초기화(생성)가 이루어진다.
// -> static이 붙은 변수와 메서드는 결론적으로 생성자와 아무 관련이 없다!
// static으로 선언된 변수와 메서드는 객체명. 으로 접근하는 않는다.
// static이 붙은 변수와 메서드는 class.으로 접근한다.
// static이 붙은 변수의 초기화는 생성자를 이용하지 않는다.
// 참조자료형만 뒤에만 .을 찍을 수 있다.(참조자료형이 호출을 할 수 있으므로)
// static은 객체 생성보다 먼저 해석된다.

public class Count {
  static int cnt;
  int price;

  // static은 별도의 초기화문법을 지닌다.
  static{
    cnt = 5;
  }

  public Count(){
    price = 0; // 멤버변수의 초기화는 생성자에서 진행하는 것이 맞다.
    price++;
    System.out.println(price);
  }

  public static void aaa(){
    System.out.println(123);
  }
}
