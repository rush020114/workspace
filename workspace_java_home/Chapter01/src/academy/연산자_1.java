public class 연산자_1 {
  public static void main(String[] args){
    // 산술 연산자(+, -, *, /, %)
    // %(mod 연산자) : 나눗셈 결과의 나머지를 구하는 연산
    System.out.println(5 % 2);
    System.out.println(6 % 2);
    System.out.println(7 % 4);
    System.out.println(7 / 4); // 정수와 정수의 연산은 정수가 나오므로 1

    // 비교 연산자 : 연산 결과가 true, false로 나옴
    // > : 크다, < : 작다, >= : 크거나 같다, <= : 작거나 같다
    // == : 같다, != : 다르다, 같지 않다.
    System.out.println(3 > 1);
    System.out.println(5 == 5);
    System.out.println(10 != 10);

    // ! : 논리부정 연산자 -> 참은 거짓으로 거짓은 참으로 변경
    System.out.println(!true);

    boolean bool = !false;
    System.out.println(bool);

    // 논리연산자 (&, |, ^)
    // and연산(이면서) : &&
    // or연산(이거나) : ||(버티컬 바)
    boolean b1 = 3 > 1 && 5 > 2;
    boolean b2 = 4 < 1 || 3 != 2;

    // 1 < x < 5

    int x = 3;
    boolean b3 = x > 1 && x < 5;
    // &&, || 중 &&가 우선순위가 높다.
    boolean b4 = 3 > 1 && 2 < 4 || 3 > 2 && 5 < 9;

  }
}
