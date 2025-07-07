package example;

public class MyMathTest {
  public static void main(String[] args) {
    MyMath myMath = new MyMath();
    System.out.println("2 또는 5의 배수 : " + myMath.isEven(3, 5, 2));
    System.out.println("1부터 받은 숫자까지 덧셈 : " + myMath.getSumFromOne(10));
    System.out.println("반지름에 대한 넓이 : " + myMath.getCircleArea(4));

    // 상수 - 변하지 않는 값
    // 상수를 구분짓기 위해 상수는 모두 대문자로 짓는다.
    final int NUM = 10;
  }
}
