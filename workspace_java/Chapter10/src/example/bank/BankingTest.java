package example.bank;

import java.util.Scanner;

public class BankingTest {
  public static void main(String[] args){
    Banking banking = new Banking();
    Scanner sc = new Scanner(System.in);
    boolean isRunning = true;

    while(isRunning){
      System.out.print("1.계좌개설 2.입금 3.출금 4.예금조회 5.계좌해지 6.전체조회 7.종료=> ");
      int selectNo = sc.nextInt();

      switch(selectNo){
        case 1:
          banking.regCustomer();
          break;
        case 2:
          banking.deposit();
          break;
        case 3:
          banking.withdraw();
          break;
        case 4:
          banking.checkMyBalance();
          break;
        case 5:
          banking.removeAccNum();
          break;
        case 6:
          banking.checkCustomerInfoAll();
          break;
        case 7:
        default:
          isRunning = !isRunning;
      }
    }
  }
}
