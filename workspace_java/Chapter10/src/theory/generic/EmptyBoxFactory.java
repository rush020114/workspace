package theory.generic;

public class EmptyBoxFactory {
  // 타겟 타입을 위한 예제
  public static <T> Box<T> makeBox(){
    Box<T> box = new Box<>();

    return box;
  }
}
