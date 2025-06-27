package 실습;

import com.sun.jdi.Value;

import java.util.Scanner;

public class Calculater {

  public void calculate(){
    Scanner sc = new Scanner(System.in);
    System.out.print("첫번째 수 : ");
    int num1 = sc.nextInt();
    System.out.print("두번째 수 : ");
    int num2 = sc.nextInt();
    System.out.print("연산자 : ");
    String op = sc.next();

    switch (op){
      case "+":
        System.out.println(num1 + op + num2 + "=" + (num1 + num2));
        break;
      case "-":
        System.out.println(num1 + op + num2 + "=" + (num1 - num2));
        break;
      case "*":
        System.out.println(num1 + op + num2 + "=" + (num1 * num2));
        break;
      case "/":
        System.out.println(num1 + op + num2 + "=" + (num1 / (double)num2));
      default:
        System.out.println("연산자를 잘못 입력하셨습니다.");
    }
  }
}
