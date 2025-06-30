package 실습;

import java.util.Scanner;

public class 무한루프문제01 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while(true){
      System.out.print("0~100사이의 정수를 입력하세요. : ");
      int i = sc.nextInt();
      if (i >= 0 && i <= 100) {
        break;
      }
    }
  }
}
