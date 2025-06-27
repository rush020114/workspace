package 실습;

import java.util.Scanner;

public class 배열문제2_1 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int num = sc.nextInt();
    int[] arr1 = new int[num];
    int sum = 0;
    for(int i = num ; i > 0 ; i--){
      arr1[i - 1] = i;
      sum = sum + arr1[i - 1];
    }
    System.out.println(sum / (double)arr1.length);
  }
}
