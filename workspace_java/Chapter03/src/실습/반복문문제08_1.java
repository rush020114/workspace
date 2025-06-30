package 실습;

import java.util.Scanner;

public class 반복문문제08_1 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int cnt = 0;
    for(int i = sc.nextInt() ; i > 0 ; i--){
      if(i % 2 == 0){
        cnt++;
      }
    }
    System.out.println(cnt);
  }
}
