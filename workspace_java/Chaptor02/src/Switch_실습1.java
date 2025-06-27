import java.util.Scanner;

public class Switch_실습1 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("1번");

    System.out.print("성별 입력 : ");
    String gender = sc.next();
    switch (gender){
      case "남":
        System.out.println("남자입니다.");
        break;
      case "여":
        System.out.println("여자입니다.");
        break;
      default :
        System.out.println("다시 입력하새요.");
    }

    System.out.println("2번");

    System.out.print("첫번째 수 : ");
    int num1 = sc.nextInt();
    System.out.print("두번째 수 : ");
    int num2 = sc.nextInt();
    System.out.print("연산자 : ");
    String op = sc.next();
    int num3 = num1 + num2;
    int num4 = num1 - num2;
    int num5 = num1 * num2;
    double num6 = (double)num1 / (double)num2;

    switch(op){
      case "+" :
        System.out.println(num1 + " " + op + " " + num2 + " = " + num3);
        break;
      case "-" :
        System.out.println(num1 + " " + op + " " + num2 + " = " + num4);
        break;
      case "*" :
        System.out.println(num1 + " " + op + " " + num2 + " = " + num5);
        break;
      case "/" :
        System.out.println(num1 + " " + op + " " + num2 + " = " + num6);
        break;
      default:
        System.out.println("연산자를 잘못 입력하셨습니다.");

    }

  }
}
