import java.security.Principal;
import java.util.Scanner;

public class 문제_10 {
  public static void main(String[] args) {
    // 키보드 입력을 위한 scanner 생성
    Scanner sc = new Scanner(System.in);

    // 문제 풀이를 위한 필요 변수 선언(문제를 풀 때는 필요한 변수를 잘 정하는 것이 중요!)
    int korScore, engScore, mathScore; // 국, 영, 수 점수 저장을 위한 변수
    int totalScore; // 총점 저장을 위한 변수
    double avg; // 평균 데이터를 저장할 변수

    //----- 국, 영, 수 점수 입력 -----
    System.out.print("국어점수 : ");
    // 키보드로 정수를 입력받고, korScore 변수에 저장
    korScore = sc.nextInt();

    System.out.print("영어점수 : ");
    engScore = sc.nextInt();

    System.out.print("수학점수 : ");
    mathScore = sc.nextInt();

    // 총점 및 평균 계산
    totalScore = korScore + engScore + mathScore;
    avg = totalScore / 3.0;

    // 총점 및 평균 출력
    System.out.println("총점 : " + totalScore);
    System.out.print("평균 : " + avg);

  }
}
