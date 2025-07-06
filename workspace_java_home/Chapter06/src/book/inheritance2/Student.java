package book.inheritance2;

public class Student {
  // 오버라이딩 : 다른 것보다 우선시한다.
  // 메서드 오버라이딩 : 자식 클래스의 메서드가 우선시되어 부모 메서드를 상속받지 않은 것처럼 된다.
  // 메서드 오버라이딩을 할 때 리턴타입, 메서드명, 매개변수가 동일해야 한다.
  // 메서드 오버라이딩에서 부모의 접근제한자보다 범위가 축소되면 안 된다.
  String name;
  int score;

  public void printInfo(){
    System.out.println(name + "의 점수 : " + score);
  }
}
