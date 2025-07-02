package yoon;

public class MethodReturn1 {
  public static void main(String[] args){
    System.out.println(adder(4, 5)); // int형 정수를 리턴해주는(사용할 수 있게 해주는) adder 매서드에 4, 5를 전달함
    double result; // 실수형 변수 선언
    result = square(3.5); // square매서드에 3.5를 전달하며 호출, 호출 후 기능을 다하여 리턴한 값(사용할 수 있게 해준 값)은 num의 제곱
    System.out.println(result); // result가 리턴된 값이므로 3.5의 제곱 출력
  }

  public static int adder(int num1, int num2){ // 위의 호출을 받아 매개변수에 4, 5 저장
    int addResult = num1 + num2; // 기능은 num1과 num2를 더해줌
    return addResult; // 리턴으로 addResult의 값을 이용할 수 있게 해줌.
  }
  public static double square(double num){ // 매개변수로 double을 받아 리턴으로 double값을 쓰게 해줌
    return num * num; // return(메서드 호출로 사용할 수 있게 된 값)을 num의 제곱으로 함
  }
}
