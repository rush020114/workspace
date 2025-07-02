import java.util.Scanner;

public class Main01_10 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();

    if ((a >= 100 && a <= 1000) && (b >= 100 && b <= 1000)) {
      System.out.println(a * (b % 10));
      // 백의 자리를 100으로 나눈 나머지는 그 수의 십의 자리 수
      // 그 십의 자리 수를 10으로 나누면 십의 자리 도출
      System.out.println(a * ((b % 100) / 10));
      System.out.println(a * (b / 100));
      System.out.println(a * b);
    }
  }
}
