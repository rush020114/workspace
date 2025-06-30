import java.util.Scanner;

public class IfExam02 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    System.out.println("두 수의 크기 비교");
    int a;
    int b;
    System.out.print("a값 입력 : ");
    a = sc.nextInt();
    System.out.print("b값 입력 : ");
    b = sc.nextInt();

    int max, min; // a값과 b값의 중 더 큰 값을 max에 작은 값을 min에 저장하기 위한 변수선언
    if (a > b) {
      max = a; // a값이 더 크므로 max에 저장
      min = b; // a가 더 크므로 b는 min에 저장
    }

    else{ // 위의 조건이 거짓이면 그 반대로 변수의 값 저장
      max = b;
      min = a;
    }

    System.out.println(max + " > " + min); // 조건문에 따라 저장된 값을 출력
  }
}
