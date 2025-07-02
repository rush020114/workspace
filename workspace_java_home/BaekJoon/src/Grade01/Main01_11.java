import java.util.Scanner;

public class Main01_11 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long A = sc.nextLong(); // 문제의 조건이 10^12까지 범위를 두고 있으므로 키보드 값 입력과 자료형을 long으로 해주었음.
    long B = sc.nextLong();
    long C = sc.nextLong();
    System.out.println(A + B + C);
  }
}
