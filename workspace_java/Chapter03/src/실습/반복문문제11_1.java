package 실습;

import java.util.Scanner;

public class 반복문문제11_1 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int sum = 0;
    int num1 = sc.nextInt(); //3
    int num2 = sc.nextInt(); //10
    for(int i = num1 ; i < (num2 - 1) ; i++){
      sum = sum + (i + 1);
    }
    for (int j = num2 ; j < (num1 - 1) ; j++){
      sum = sum + (j + 1);
    }
    System.out.println(sum);

  }
}
