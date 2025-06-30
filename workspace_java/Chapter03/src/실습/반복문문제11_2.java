package 실습;

import java.util.Scanner;

public class 반복문문제11_2 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("첫번째 수 : ");
    int num1 = sc.nextInt();
    System.out.print("두번째 수 : ");
    int num2 = sc.nextInt();

    //입력받은 두 수에서 큰 수와 작은 수를 구분
    int max = num1 > num2 ? num1 : num2;
    int min = num1 > num2 ? num2 : num1;

    int sum = 0;

    int i = min + 1;
    while(i < max){
      sum = sum + i;
      i++;
    }
    System.out.println(sum);
  }
}
