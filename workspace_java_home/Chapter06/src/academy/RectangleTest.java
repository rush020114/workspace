package academy;

public class RectangleTest {
  public static void main(String[] args){
    Object rectangle1 = new Rectangle(20, 15); // Object는 모든 클래스의 부모클래스이므로 Rectangle 객체를 받을 수 있다.
    Object rectangle2 = new Rectangle(10, 30);

    System.out.println(rectangle1.equals(rectangle2)); // 메서드 오버라이딩을 통해 Object 클래스의 equals 대신 Rectangle만의 equals 클래스를 만들었다.
    // 메서드 오버라이딩으로 객체지향 프로그래밍(실세계와 비슷한 프로그래밍 기법)에 가까워질 수 있다.

  }
}
