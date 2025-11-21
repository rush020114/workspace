package theory.generic;

public class BoxGenericTest {
  public static void main(String[] args){
    // Box<T>에서 T는 타입 매개변수
    // Box<Apple>에서 Apple은 타입 인자
    // Box<Apple> 매개변수화 타입
    // new Box<Apple>() : Box 클래스의 T를 Apple로 결정하여 생성하겠다.(Box 클래스의 T들이 다 Apple로 변해서 생성)
    // Box<Apple> : T가 Apple로 결정된 인스턴스를 참조하는 참조변수 선언
    Box<Apple> aBox = new Box<Apple>();
    Box<Orange> obox = new Box<Orange>();

    aBox.set(new Apple());
    obox.set(new Orange());

    // 형변환을 하지 않아도 됨!
    Apple ap = aBox.get();
    Orange og = obox.get();

    System.out.println(ap);
    System.out.println(og);
  }
}
