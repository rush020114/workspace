package academy.emp;

import java.util.Scanner;

public class EmpTest {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    EmpService empService = new EmpService();
    boolean isRunning = true;

    while(isRunning){
      System.out.print("1.로그인 2.월급현황 3.인상월급 : ");
      int selectNo = sc.nextInt();
      switch(selectNo){
        case 1:
          System.out.print("사번 : ");
          int empNum = sc.nextInt();
          System.out.print("비밀번호 (연락처의 마지막 4자리) : ");
          String password = sc.next();
          empService.login(empNum, password);
          break;
        case 2:
          empService.checkSalaryInfo(empService.insertDept());
          break;
        case 3:
          empService.checkUpSalaryInfo(empService.insertDept(), empService.insertUpSalary());
          break;
        default:
          isRunning = !isRunning;
      }
    }
  }
}
