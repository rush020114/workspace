import java.util.Arrays;
import java.util.Scanner;

public class Test {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[] gameArr = new int[5];
    int[] newGameArr = new int[gameArr.length];
    int gameCnt = 1;

    for(int i = 0 ; i < gameArr.length ; i++){
      int cnt = 0;
      gameArr[i] = (int)(Math.random() * 9 + 1);
      for(int j = 0 ; j < i ; j++){
        if(gameArr[i] == gameArr[j]){
          cnt++;
        }
      }

      if(cnt == 0){
        newGameArr[i] = gameArr[i];
      }
      else{
        i--;
      }
    }
    System.out.println("숫자를 정했습니다. 게임을 시작합니다.");
    while(true){
      int[] compareArr = new int[gameArr.length];
      int strike = 0;
      int ball = 0;
      System.out.print(gameCnt + " >> ");

      for(int i = 0 ; i < gameArr.length ; i++){
        compareArr[i] = sc.nextInt();
      }

      for(int i = 0 ; i < gameArr.length ; i++){
        for(int j = 0 ; j < gameArr.length ; j++){
          if(i != j && newGameArr[i] == compareArr[j]){
            ball++;
          }
        }
      }

      for(int i = 0 ; i < gameArr.length ; i++){
        if(newGameArr[i] == compareArr[i]){
          strike++;
        }
      }

      if(strike == 0){
        System.out.println(strike + "스트라이크 " + ball + "볼");
      }

      if(strike > 0){
        System.out.println(strike + "스트라이크 " + ball + "볼");
      }

      if(strike == gameArr.length){
        System.out.println(gameCnt + "회만에 정답을 맞혔습니다.");
        break;
      }

      gameCnt++;
    }
  }
}
