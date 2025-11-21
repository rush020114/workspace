package theory.generic;

public class DBoxTest {
  // Box<Apple> aBox = new Box<>();
  // 위의 문법이 가능한 이유는
  // 참조변수 선언 때 컴파일러가 알아서 유추해서 Apple의 값을 넣어주기 때문
  public static void main(String[] args){
    DBox<String, Integer> box = new DBox<String, Integer>();

    box.set("apple", 25);
    System.out.println(box);
  }
}
