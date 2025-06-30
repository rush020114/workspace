import java.util.Scanner;

public class IF_2 {
  public static void main(String[] args){

    // 키보드로 정수 하나를 입력 받아,
    // 입력받은 정수가 짝수일 때만, "A" 문자열을 출력하세요.

    Scanner sc = new Scanner(System.in);
    System.out.print("정수 입력 : ");
    int num = sc.nextInt();

    // 만약애 x가 짝수라면...
    if ((num % 2) == 0) {
      System.out.println("A");
    }

    if ((num % 2) != 0) {
      System.out.println("삐빅!");
    }

  }
}
