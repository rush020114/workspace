package 이론;

public class ComputerTest {
  public static void main(String[] args){
    Computer c1 = new Computer("삼성", 1000); // 생성자로 초기화한 새로운 객체를 만들어서 c1에 넣겠습니다.
    c1.display();

    // 참조자료형은 선언하면 무조건 null을 가진다.
    int[] aaa;
    String a; // String도 참조 자료형이므로 선언만 돼 있으면 null을 가진다.

    Computer c2 = c1; // c2는 c1의 데이터를 가지게 된다.
    c2.display();
    c2.price = 2000;
    c1.display();

    Computer[] array = new Computer[3]; // 모든 자료형은 배열로 가능하므로 클래스도 자료형이니 배열로 형성 가능하다.



  }

  public Computer test(Computer c) {
    c.display();
    return c;
  }

}
