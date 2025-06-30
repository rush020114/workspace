package 이론;

import java.util.Scanner;

public class 무한루프_1 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // 무한루프 : while의 소괄호에 true를 넣어 무한히 실행시킨다. for문도 가능하지만 while을 쓴다.
    while (true) {
      System.out.print("짝수를 입력하세요. : ");
      int i = sc.nextInt();
      if (i % 2 == 0) { // 입력받은 수가 짝수라면 반복문을 벗어나세요.
        break;
      }
    }
  }
}
