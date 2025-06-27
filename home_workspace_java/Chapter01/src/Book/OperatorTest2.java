public class OperatorTest2 {
  public static void main(String[] args){
    // 증감연산자
    // 증가연산자
    int score = 10;
    System.out.println("score 값 : " + score); // 10
    ++score; // 1증가
    System.out.println("score 값 : " + score); // 11
    score++; // 1증가
    System.out.println("score 값 : " + score); // 12

    System.out.println("score 값 : " + ++score); // 앞에 ++가 있으면 변수의 값을 먼저 증가시키므로 13
    System.out.println("score 값 : " + score++); // 뒤에 ++가 있으면 변수의 값을 먼저 사용하고 증가시키므로 13
    // 사실 개발할 때 이런 고민을 할 일이 없을 것
    System.out.println("score 값 : " + score); // 14

    // 감소연산자
    System.out.println("score 값 : " + --score); // --가 앞에 있으면 변수의 값을 먼저 감소시키므로 13
    System.out.println("score 값 : " + score--); // --가 뒤에 있으면 변수의 값을 먼저 사용하고 감소시키므로 13
    System.out.println("score 값 : " + score); // 12

  }
}
