package academy;

import java.util.Scanner;

public class ArrayExample03 {
  // 다음은 키보드로부터 학생 수와 학생들의 점수를 입력받아, 최고점수 및 평균 점수를 구하는 프로그램입니다.
  public static void main(String[] args){
    boolean run = true;
    int studentNum = 0;
    int[] scores = null; // 정수형 배열 score의 값이 정의되지 않았음.(참조할 것이 없다는 뜻으로 해석)
    Scanner sc = new Scanner(System.in);

    while (run) {
      System.out.println("------------------------------------------------");
      System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
      System.out.println("------------------------------------------------");
      System.out.print("선택 > ");

      int selectNo = sc.nextInt();

      switch (selectNo){
        case 1 :
          System.out.print("학생 수 > ");
          studentNum = sc.nextInt();
          scores = new int[studentNum]; // 정수형 배열 score를 studentNum의 정수로 초기화(각 요소에 든 값은 0)
          break;
        case 2 :
          for(int i = 0 ; i < scores.length ; i++){
            System.out.print("score[" + i + "] > ");
            scores[i] = sc.nextInt();
          }
          break;
        case 3 :
          for(int i = 0 ; i < scores.length ; i++){
            System.out.println("score[" + i + "] : " + scores[i]);
          }
          break;
        case 4 :
          int sum = 0;
          int max = scores[0];
          for(int i = 0 ; i < scores.length ; i++){
            sum = sum + scores[i];
            if(max < scores[i]){
              max = scores[i];
            }
          }
          System.out.println("최고 점수 : " + max);
          System.out.println("평균 : " + ((double)sum / scores.length));
          break;
        case 5 :
        default :
          run = false;
      }
    }
    System.out.println("프로그램 종료");
  }
}
