package 실습;

import java.util.Scanner;

public class CalTest {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    Cal cal = new Cal();
    System.out.print("첫번째 수 : ");
    cal.setNum1(sc.nextInt());
    System.out.print("두번째 수 : ");
    cal.setNum2(sc.nextInt());
    System.out.print("연산자 : ");
    String oper = sc.next();
    switch(oper){
      case "+":
        System.out.println(cal.getNum1() + oper + cal.getnum2() + "=" + cal.getSum());
        break;
      case "-":
        System.out.println(cal.getNum1() + oper + cal.getnum2() + "=" + cal.getSub());
        break;
      case "*":
        System.out.println(cal.getNum1() + oper + cal.getnum2() + "=" + cal.getMulti());
        break;
      case "/":
        System.out.println(cal.getNum1() + oper + cal.getnum2() + "=" + cal.getDiv());
    }
  }
}
