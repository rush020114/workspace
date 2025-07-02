public class LogicalOp {
  public static void main(String[] args){
    //논리연산자는 true, false 값을 반환하는 연산과 함께 쓰여 true, false를 반환한다.
    int num1 = 11;
    int num2 = 22;
    boolean result;

    // num1이 1과 100사이인가
    result = num1 > 1 && num1 < 100;
    System.out.println(result);

    // num2가 2의 배수 또는 3의 배수인가
    result = num2 % 2 == 0 || num2 % 3 ==0;
    System.out.println(result);

    // num1이 0인가
    result = !(num1 != 0);
    System.out.println(result);
  }
}
