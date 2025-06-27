import java.util.Scanner;

public class 삼항연산자_연습1 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    System.out.print("정수 입력 : ");
    int a = sc.nextInt();
    // a가 짝수이면 짝수입니다 출력 홀수이면 홀수입니다 출력, 출력 결과는 문자열 형태
    System.out.println(a % 2 ==0 ? "짝수입니다." : "홀수입니다.");
  }
}
