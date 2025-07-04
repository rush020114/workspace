package theory;

public class TvTest {
  public static void main(String[] args){
    Tv tv = new Tv();
    Tv tv1 = new Tv();
    tv.turnOn();

    // tv 객체와 tv1 객체의 참조값이 같습니까?
    System.out.println(tv.equals(tv1));

    tv = tv1;
    System.out.println(tv.equals(tv1));

    Rect r1 = new Rect(10, 20);
    Rect r2 = new Rect(10, 20);


    System.out.println(r1.equals(r2));

    System.out.println(r2.toString());
    System.out.println(r2);
    int[] arr = new int[2];
    System.out.println(arr.toString());
    System.out.println(arr);

    String name = "kim";
    name.equals("lee"); // 문자열 equals 메서드는 object의 equals 기능(참조주소를 비교하는 기능)을 이미 오버라이딩(문자열을 비교하는 기능)해서 재정의한 상태이다
    name.equals("");


    // 자료형 변수명;
    // int a;(변수명)
    // String b;(변수명, 참조변수, 객체)
    // Rect r;(변수명, 참조변수, 객체)
    // int[] a;(변수명, 참조변수, 객체, 배열)
    // List<String> a;(변수명, 참조변수, 객체, 리스트)
  }
}