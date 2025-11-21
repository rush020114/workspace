package theory.generic;

public class BoxFactory {
  // 기존의 제네릭 클래스는 인스턴스 생성 시점에 타입이 정해졌었다.
  // 제네릭 메서드는 메서드 호출 시에 타입을 정해주면 된다.
  public static <T> Box<T> makeBox(T o){
    Box<T> box = new Box<>();
    box.set(o);
    return box;
  }

  public static <T extends Number> int makeBox1(T o){
    return o.intValue();
  }

  // T에 Number를 extends 해놨기 떄문에
  // Integer를 타입 인자로 전달하면 Box<T>의 getter로 Integer가 반환되고
  // Interger는 intValue가 되기 때문에 문법적 허용이 된다.
  public static <T extends Number> T makeBox2(Box<T> o){
    System.out.println("Unboxed Data : " + o.get().intValue());
    return o.get();
  }
}
