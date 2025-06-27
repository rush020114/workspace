import java.util.Scanner;

public class 문제_1_10 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("첫번째 수 : ");
    int a = sc.nextInt();
    System.out.print("두번째 수 : ");
    int b = sc.nextInt();
    System.out.print("세번째 수 : ");
    int c = sc.nextInt();

    int min, mid, max;

    // min, mid, max 변수에 값 저장하기
    // a가 가장 큰 값이라면...

    // if조건문 안에 if조건문이 또 들어갈 수 있다.
    // a가 가장 큰 경우
    if(a > b && a > c) {
      max = a;
      mid = b > c ? b : c;
      min = c > b ? b : c;
    }
    // b가 가장 큰 경우
    else if(b > a && b > c) {
      max = b;
      mid = a > c ? a : c;
      min = c > a ? a : c;
    }

    // 그렇지 않으면 (c가 가장 큰 경우)
    else{
      max = c;
      mid = a > b ? a : b;
      min = b > a ? a : b;
    }

    // 결과출력
    System.out.println(max + " > " + mid + " > " + min);

  }
}
