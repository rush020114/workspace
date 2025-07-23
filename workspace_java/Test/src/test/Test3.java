package test;

import java.util.Scanner;

public class Test3 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    System.out.print("1 ~ 999까지의 3, 6, 9 게임 박수 판별 프로그램 : ");
    int gameNum = sc.nextInt();
    int hundreds = gameNum / 100;
    int tens = (gameNum / 10) % 10;
    int ones = gameNum % 10;
    int cnt = 0;

    if(hundreds % 3 == 0 && hundreds != 0){
      cnt++;
    }

    if(tens % 3 == 0 && tens != 0){
      cnt++;
    }

    if(ones % 3 == 0 && ones != 0){
      cnt++;
    }
    System.out.println("박수 " + cnt + "번");
  }
}