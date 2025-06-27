package 실습;

import java.util.Scanner;

public class 배열문제12_2 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    String[] subjects = {"국어", "수학", "영어", "사회", "과학", "역사"};
    int[] scores = new int[subjects.length + 1];
    for(int i = 0 ; i < subjects.length ; i++){
      while (true){
        System.out.print(subjects[i] + "점수 : ");
        scores[i] = sc.nextInt();
        if(scores[i] >= 0 && scores[i] <= 100){
          break;
        }
        System.out.println("다시 입력" + "\n");
      }
      scores[subjects.length] = scores[subjects.length] + scores[i];
    }
    System.out.println("총점 : " + scores[subjects.length]);
    if(scores[subjects.length] % subjects.length == 0){
      System.out.println(scores[subjects.length] / subjects.length);
    }
    if(scores[subjects.length] % subjects.length != 0){
      System.out.println(scores[subjects.length] / (double)subjects.length);
    }
  }
}
