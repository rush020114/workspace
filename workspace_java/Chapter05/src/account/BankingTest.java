package account;

import java.util.Scanner;

public class BankingTest {
  public static void main(String[] args){
    boolean isRunning = true;
    Banking banking = new Banking();
    Scanner sc = new Scanner(System.in);

    while(isRunning){
      System.out.print("1.계좌개설 2.입금 3.출금 4.예금조회 5.전체조회 6.은행업무종료 => ");
      int selectNum = sc.nextInt();

      switch (selectNum){
        case 1:
          banking.regAccount();
          System.out.println();
          break;
        case 2:
          banking.deposit();
          System.out.println();
          break;
        case 3:
          banking.withdraw();
          System.out.println();
          break;
        case 4:
          banking.checkbalance();
          System.out.println();
          break;
        case 5:
          banking.checkAll();
          System.out.println();
          break;
        case 6:
        default:
          System.out.println("은행업무를 종료합니다.");
          isRunning = !isRunning;
      }
    }
  }
}
