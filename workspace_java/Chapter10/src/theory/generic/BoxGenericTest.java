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

    // 형변환을 하지 않아도 됨.
    Apple ap = aBox.get();
    Orange og = obox.get();

    System.out.println(ap);
    System.out.println(og);

    Box<String> sBox = new Box<>();
    sBox.set("I am so Happy");

    Box<Box<String>> wBox = new Box<>();
    wBox.set(sBox);

    Box<Box<Box<String>>> zBox = new Box<>();
    zBox.set(wBox);
    System.out.println(zBox);

    // 제네릭 메서드는 호출 시 타입 인자를 정해주면 된다.
    Box<String> stringBox = BoxFactory.<String>makeBox("Sweet");
    Box<Double> dBox = BoxFactory.<Double>makeBox(1.2);

    // 타입인자를 생략가능하다.(매개변수 전달 시 컴파일러가 판단)
    Box<String> stringBox1 = BoxFactory.makeBox("Sweet");
    Box<Double> dBox1 = BoxFactory.makeBox(3.2);

    // 제네릭 메서드는 매개변수를 전달할 때 타입 매개변수가 정해진다.
    // makeBox2 제네릭 메서드에 makeBox2가 요구하는 매개변수를 전달하니
    // 타입인자가 Double로 되어 기능을 수행한다.
    BoxFactory.makeBox2(dBox1);
  }
}
