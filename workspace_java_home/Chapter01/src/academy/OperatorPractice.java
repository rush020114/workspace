import java.util.Scanner;

public class OperatorPractice {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in); //키보드값을 입력받겠다.
    System.out.println("a * b > 0이 성립하는 값을 입력하라.");

    System.out.print("a의 값은 : ");
    int a = sc.nextInt(); //정수의 값을 입력받겠다.
    System.out.print("b의 값은 : ");
    int b = sc.nextInt();

    // a와 b가 0보다 크거나 a와 b가 0보다 작다.
    // &&가 ||보다 우선순위
    boolean b1 = a > 0 && b > 0 || a < 0 && b < 0;
    System.out.println(b1);
  }
}
