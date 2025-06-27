package 실습;

import java.util.Scanner;

public class 배열문제12_1 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    // 0 : 국어점수, 1 : 영어점수, 2 : 수학점수, 3 : 총점
    String[] subjects = {"국어", "영어", "수학", "과학", "사회", "역사"};
    int[] scores = new int[subjects.length + 1];
    // 평균
    double avg;
    // ----- 점수 입력 -----

    for(int i = 0 ; i < subjects.length ; i++){
      while(true){
        System.out.print(subjects[i] + "점수 : ");
        scores[i] = sc.nextInt();
        if(scores[i] >= 0 && scores[i] <= 100){
          System.out.println(subjects[i] + "점수 - " + scores[i]);
          break;
        }
        System.out.println("다시 입력" + "\n");
      }
      scores[subjects.length] = scores[subjects.length] + scores[i];
    }

    // 평균
    avg = scores[subjects.length] / (double)(subjects.length);
    System.out.println("총점 : " + scores[subjects.length]);
    System.out.println("평균 : " + avg);
  }
}
