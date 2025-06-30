package 실습;

import java.util.Scanner;

public class 반복문문제08 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("정수 : ");
    int i = sc.nextInt();
    int evenCnt = 0;
    while (i > 0) {
      if (i % 2 == 0) {
        evenCnt++;
      }
      i--;
    }
    System.out.println(evenCnt);
  }
}
