import java.sql.SQLOutput;
import java.util.Scanner;

public class 값입력_4 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in); //키보드로 값을 입력할 수 있게 해주겠다.
    System.out.print("국어점수 : "); // 문자열 "국어점수 :" 에 대한 한 줄 개행하지 않은 출력문
    int korScore = sc.nextInt(); // 키보드로 입력한 정수의 값을 정수 형태 korScore에 저장하겠다.
    System.out.print("영어점수 : ");
    int engScore = sc.nextInt();
    System.out.print("수학점수 : ");
    int mathScore = sc.nextInt();

    System.out.print("총점 : " + (korScore + engScore + mathScore)); //모든 점수의합
    System.out.println(); // 입력값 없이 한 줄 개행

    //모든 점수의 평균
    //우선연산자부터 계산 후 정수와 실수의 계산이므로 실수가 값으로 나옴
    System.out.print("평균 : " + ((korScore + engScore + mathScore) / 3.0));
  }
}