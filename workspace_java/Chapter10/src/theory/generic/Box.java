package theory.generic;

// 제네릭 : 클래스에 자료형을 결정 짓지 않고 틀만 만들어 놓는다.
// 컴파일, 예외에서도 오류를 잡아내지 못하여 잘못 실행되는 코드를 막을 수 있다.
// 제네릭은 일단 클래스만 정의해놓고 자료형을 나중에 정할 수 있다.(<T>를 사용)
public class Box<T> {
  private T ob;


  public T get(){
    return ob;
  }

  public void set(T o){
    ob = o;
  }
}

class Apple {
  public String toString(){
    return "I am an apple";
  }
}

class Orange {
  public String toString(){
    return "I am an orange";
  }
}

class Toy {
  public String toString(){
    return "I am a Toy";
  }
}

class BoxHandler{
  // ? extends Toy → 상한 제한 (Producer)
  // Box 안에는 Toy 또는 Toy의 자식 타입이 들어있을 수 있다.
  // 꺼낼 때는 최소한 Toy 타입임이 보장되므로 안전하게 꺼낼 수 있다.
  // 하지만 넣을 때는 정확한 자식 타입을 알 수 없으므로 컴파일러가 막는다.
  // 만약 Box<RobotToy>가 들어왔는데 new Toy()를 넣으려 하면 타입 불일치가 발생
  public static void outBox(Box<? extends Toy> box){
    Toy t = box.get();
    // box.set(new Toy());
  }

  // ? super Toy → 하한 제한 (Consumer)
  // Box 안에는 Toy 또는 Toy의 부모 타입이 들어있을 수 있다.
  // 넣을 때는 Toy 객체를 안전하게 넣을 수 있다. (부모 박스에도 자식 객체를 넣을 수 있음)
  // 하지만 꺼낼 때는 최소 Object 타입만 보장되므로 Toy로 단정할 수 없어 컴파일러가 막는다.
  // 예를 들어 Box<Object>일 수도 있는데, 꺼내면 Object 타입이지 Toy라고 확신할 수 없음
  public static void inBox(Box<? super Toy> box, Toy n){
    box.set(n);
    // Toy myToy = box.get();
  }
}