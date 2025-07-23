package test;

import java.util.Arrays;
import java.util.Scanner;

public class Test5 {
  public static void main(String[] args){
    int[] gameArr = new int[3];
    Scanner sc = new Scanner(System.in);
    int cnt = 1;

    for(int i = 0 ; i < gameArr.length ; i++){
      int num = (int)(Math.random() * 9 + 1);
      if(gameArr[0] == num || gameArr[1] == num || gameArr[2] == num){
        i--;
        continue;
      }
      gameArr[i] = num;
    }
    System.out.println("숫자를 정했습니다. 게임을 시작합니다.");

    while(true){
      System.out.print(cnt + " >> ");
      int[] gameArr2 = new int[3];
      int strike = 0;
      int ball = 0;
      for(int i = 0 ; i < gameArr2.length ; i++){
        gameArr2[i] = sc.nextInt();
      }

      if(gameArr[0] == gameArr2[0]){
        strike++;
      }
      if(gameArr[1] == gameArr2[1]){
        strike++;
      }
      if(gameArr[2] == gameArr2[2]){
        strike++;
      }

      if(gameArr[0] == gameArr2[1] || gameArr[0] == gameArr2[2]){
        ball++;
      }
      if(gameArr[1] == gameArr2[0] || gameArr[1] == gameArr2[2]){
        ball++;
      }
      if(gameArr[2] == gameArr2[0] || gameArr[2] == gameArr2[1]){
        ball++;
      }

      if(strike == 0 && ball == 0){
        System.out.println(strike + "스트라이크 " + ball + "볼");
      }

      if(strike == 0){
        if(ball == 1){
          System.out.println(strike + "스트라이크 " + ball + "볼");
        }
        if(ball == 2){
          System.out.println(strike + "스트라이크 " + ball + "볼");
        }
        if(ball == 3){
          System.out.println(strike + "스트라이크 " + ball + "볼");
        }
      }

      if(strike == 1){
        System.out.println(strike + "스트라이크 " + ball + "볼");
      }

      if(strike == 2){
        System.out.println(strike + "스트라이크 " + ball + "볼");
      }

      if(strike == 3){
        System.out.println(strike + "스트라이크 " + ball + "볼");
        System.out.println(cnt + "회만에 정답을 맞혔습니다.");
        break;
      }
        cnt++;
    }

  }
}
