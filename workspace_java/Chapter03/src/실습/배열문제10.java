package 실습;

import java.util.Scanner;

public class 배열문제10 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[] arr1 = new int[5];
    for(int i = 0 ; i < arr1.length ; i++){
      int num = sc.nextInt();
      arr1[i] = num;
    }
    for(int i = 0 ; i < arr1.length ; i++){
      System.out.println(arr1[i]);
    }
  }
}
