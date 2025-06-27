import java.util.Scanner;

public class IF_실습2 {
  public static void main(String[] args) {
    System.out.println("1번");
    Scanner sc = new Scanner(System.in);
    String gender;
    System.out.print("성별을 입력하세요 : ");
    gender = sc.next();

    if (gender.equals("M")){
      System.out.println("남자입니다.");
    }

    else if (gender.equals("F")){
      System.out.println("여자입니다.");
    }

    else{
      System.out.println("다시 입력하세요.");
    }

    System.out.println("3번");

    int num1, num2;
    String operator;

    System.out.print("첫 번째 수 : ");
    num1 = sc.nextInt(); // 첫번째 정수를 입력받겠다.

    System.out.print("두 번째 수 : ");
    num2 = sc.nextInt(); // 두번째 정수를 입력받겠다.

    System.out.print("연산자 : ");
    operator = sc.next(); // 문자열을 입력받겠다.

    int num3 = num1 + num2;
    int num4 = num1 - num2;
    int num5 = num1 * num2;
    double num6 = (double)num1 / (double)num2;

    if ((operator.equals("+"))) {
      System.out.println(num1 + operator + num2 + "=" + num3);
    } // num1과 num2의 합이 num3이면서 +문자열이 쓰였다면 num1 + num2 = num3를 출력해주겠다.
    else if ((operator.equals("-"))) {
      System.out.println(num1 + operator + num2 + "=" + num4);
    }
    else if ((operator.equals("*"))) {
      System.out.println(num1 + operator + num2 + "=" + num5);
    }
    else if ((operator.equals("/"))) {
      System.out.println(num1 + operator + num2 + "=" + num6);
    }

    else{
      System.out.println("연산자를 잘못입력하셨습니다.");
    }

  }
}
