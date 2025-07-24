import java.util.Arrays;
import java.util.Scanner;

public class BaseballGame {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int[] arr = new int[3];
    int[] answer = new int[arr.length];

    for(int i = 0 ; i < arr.length ; i++){
      arr[i] = (int)(Math.random() * 9 + 1);
      for(int j = 0 ; j < i ; j++){
        if(arr[i] == arr[j]){
          i--;
        }
      }
    }
    System.out.println(Arrays.toString(arr));
    System.out.println("게임을 시작합니다.");
    int tryCnt = 0;
    while(true){
      int strike = 0;
      int ball = 0;
      System.out.print(++tryCnt + " >> ");
      for(int i = 0 ; i < arr.length ; i++){
        answer[i] = sc.nextInt();
      }

      for(int i = 0 ; i < arr.length ; i++){
        for(int j = 0 ; j < arr.length ; j++){
          if(arr[i] == answer[j]){
            if(i == j){
              strike++;
            }
            else{
              ball++;
            }
          }
        }
      }
      System.out.println(strike + "스트라이크 " + ball + "볼");
      if(strike == arr.length){
        System.out.println(tryCnt + "회만에 정답을 맞혔습니다.");
        break;
      }
    }
  }
}
