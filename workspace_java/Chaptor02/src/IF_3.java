import java.util.Scanner;

public class IF_3 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    System.out.print("첫번째 정수 : ");
    int x = sc.nextInt(); // 키보드로 입력받은 정수를 저장할 변수
    System.out.print("두번째 정수 : ");
    int y = sc.nextInt(); //  키보드로 입력받은 정수를 저장할 변수

    // 만약에 입력받은 두 수의 합이 10이상이면...
    if (x + y >= 10) {
      System.out.println("합이 10 이상입니다.");
    }

    // 만약애 입력받은 두 수의 합이 10미만이면
    if (x + y < 10) {
      System.out.println("합이 10 이상이 아닙니다.");
    }

  }
}
