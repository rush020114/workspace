package book;

public class WhileTest1 {
  public static void main(String[] args) {
    // while문은 프로그램 실행 횟수를 명확히 알지 못할 때 사용한다.
    // while문은 초기식 조건식 증감식이 각각 떨어져 있다.

    int sum = 0;
    int i = 1;
    while (i < 11) {
      if (i % 2 == 0) {
        sum = sum + i;
      }
      i++;
    }
    System.out.println("짝수의 합 : " + sum);


  }
}
