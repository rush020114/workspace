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
  // extends로 상한 제한을 둠으로써 꺼내기만 가능해졌다.
  // 컴파일러 입장에선 Toy가 상속하는 무언가가 전달될 수도 있다는 것을 파악하고 있다.
  // 결론적으로 Box클래스엔 Toy의 자식 클래스가 들어갈 수 있기 때문에 컴파일러가 오류를 낸다.
  public static void outBox(Box<? extends Toy> box){
    Toy t = box.get();
    // box.set(new Toy());
  }

  // 마찬가지로 상한 제한을 둠으로써 넣기만 가능해졌다.
  // 컴파일러 입장에선 Toy를 상속하는 무언가가 전달될 수도 있다는 것을 파악하고 있다.
  // 결론적으로 Box클래스엔 Toy의 부모 클래스가 들어갈 수 있기 때문에 컴파일러가 오류를 낸다.
  public static void inBox(Box<? super Toy> box, Toy n){
    box.set(n);
    // Toy myToy = box.get();
  }
}