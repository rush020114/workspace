package 실습;

import java.util.Scanner;

public class 배열문제10_1 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[] arr = new int[5];
    for(int i = 0 ; i < arr.length ; i++){
      System.out.print(i + "번째 요소의 값 : ");
      arr[i] = sc.nextInt();
    }
    for(int e : arr){
      System.out.println(e);
    }
  }
}
