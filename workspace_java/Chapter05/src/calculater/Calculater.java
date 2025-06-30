package calculater;

import java.util.Scanner;

public class Calculater {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    System.out.print("첫번째 수 : ");
    int a = sc.nextInt();
    System.out.print("두번째 수 : ");
    int b = sc.nextInt();
    System.out.print("연산자 : ");
    String op = sc.next();
    switch(op){
      case "+":
        Add add = new Add();
        add.setValue(a, b);
        System.out.println(a + op + b + " = " + add.calculate());
        break;
      case "-":
        Sub sub = new Sub();
        sub.setValue(a, b);
        System.out.println(a + op + b + " = " + sub.calculate());
        break;
      case "*":
        Mul mul = new Mul();
        mul.setValue(a, b);
        System.out.println(a + op + b + " = " + mul.calculate());
        break;
      case "/":
        Div div = new Div();
        div.setValue(a, b);
        System.out.println(a + op + b + " = " + div.calculate());
    }
  }
}
