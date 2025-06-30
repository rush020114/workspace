package example;

import java.util.Scanner;

public class EmpTest {
  public static void main(String[] args){
    EmpService empService = new EmpService();
    Scanner sc = new Scanner(System.in);
    boolean isRunning = true;

    while(isRunning){
      System.out.print("1.등록 2.로그인 3.월급정보 4.월급인상 5.종료 : ");
      int selectNo = sc.nextInt();
      switch(selectNo){
        case 1:
          empService.regEmp();
          break;
        case 2:
          empService.login();
          break;
        case 3:
          empService.printPay();
          break;
        case 4:
          empService.upPay();
          break;
        case 5:
        default:
          isRunning = !isRunning;
      }
    }
  }
}
