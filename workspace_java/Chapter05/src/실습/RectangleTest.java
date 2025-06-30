package 실습;

public class RectangleTest {
  public static void main(String[] args){
    Rectangle r = new Rectangle();
    Rectangle s = new Rectangle(1, 5, -2, 3);

    r.show();
    s.show();
    System.out.println(s.square());
    r.set(-2, 2, -1, 4);
    r.show();
    System.out.println(r.square());
    if(r.equals(s)){ // Rectangle r의 객체의 equals메서드 호출
      System.out.println("두 사각형의 넓이가 같습니다.");
    }

  }
}
