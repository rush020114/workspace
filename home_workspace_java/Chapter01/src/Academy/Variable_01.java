public class Variable_01 {
  public static void main(String[] args) {
    int num1; // 변수 num1을 정수로 선언
    num1 = 10; // 변수 num1에 10을 저장

    int num2 =20; // 변수 num2의 선언과 동시에 20으로 초기화
    // java에서 '='는 같다가 아닌 저장의 의미이다.
    // 오른쪽에서 왼쪽으로 해석하면 편하다.
    int num3 = num1 + num2; // 두 변수 값을 대상으로 덧셈

    //출력값은 문자로 되고 "10 + 20 = 30"으로 된다.
    System.out.println(num1 + " + " + num2 + " = " + num3);
  }
}
