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