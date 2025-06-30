package 실습;

import java.util.Scanner;

public class 반복문문제11 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("i값 : ");
    int i = sc.nextInt();
    System.out.print("j값 : ");
    int j = sc.nextInt();
    int sum = 0;
    while (i < (j - 1) || (i - 1) > j) { // i가 j보다 작거나 j가 i보다 작아질 때까지 반복
      if (i < j) { // i가 j보다 작다면
        sum = sum + (i + 1); // i에 1을 더해주지 않으면 i값부터 저장하기에 1을 더해줌
        i++;
        // 3이랑 5로 치면 3이 4보다 작으면 반복 멈춤 sum에 4저장 i는 4로 됨
      }
      else if(i > j){
        sum = sum + (j + 1);
        j++;
      }
    }
    System.out.println(sum);
  }
}
