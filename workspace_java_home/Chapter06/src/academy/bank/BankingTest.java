package academy.bank;

import java.util.Scanner;

public class BankingTest {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    Banking banking = new Banking();
    boolean isRunning = true;

    while(isRunning){
      System.out.print("1.계좌개설 2.임금 3.출금 4.예금조회 5.전체조회 6은행업무종료 => ");
      int selectNo = sc.nextInt();

      switch(selectNo){
        case 1:
          banking.createAccount();
          break;
        case 2:
          banking.deposit();
          break;
        case 3:
          banking.withdraw();
          break;
        case 4:
          banking.getAccountBalance();
          break;
        case 5:
          banking.getCustomerInfo();
          break;
        case 6:
        default:
          isRunning = !isRunning;
      }
      System.out.println();
    }
    System.out.println("은행업무를 종료합니다.");
  }
}
