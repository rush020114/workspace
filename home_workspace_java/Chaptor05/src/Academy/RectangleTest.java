package Academy;

public class RectangleTest {
  public static void main(String[] args){
    Rectangle r = new Rectangle();
    Rectangle s = new Rectangle(1, 1, 2, 3); // Rectangle을 참조할 수 있는 변수(객체) s 선언과 생성자로 Rectangle의 멤버변수를 초기화한 객체 생성

    r.show();
    s.show();
    System.out.println(s.square());
    r.set(-2, 2, -1, 4);
    r.show();
    System.out.println(r.square());
    if(r.equals(s)){
      System.out.println("두 사각형은 같습니다.");
    }
  }

}
