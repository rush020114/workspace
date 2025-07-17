package academy.bank;

import java.util.Scanner;

public class Banking {
  private Customer[] customers;
  int cnt;
  Scanner sc;

  public Banking(){
    customers = new Customer[5];
    sc = new Scanner(System.in);
    cnt = 0;
  }

  // 계좌 개설
  public void createAccount(){
    System.out.println("계좌 개설을 시작합니다.");
    System.out.print("이름 : ");
    String name = sc.next();
    System.out.print("주민등록번호 : ");
    String idenNum = sc.next();
    System.out.print("연락처 : ");
    String tel = sc.next();
    System.out.print("계좌번호 : ");
    Account account = new Account(sc.next());
    customers[cnt++] = new Customer(name, idenNum, tel, account);
  }

  // 입금
  public void deposit(){
    System.out.print("입금계좌번호 : ");
    String accountNum = sc.next();
    for(Customer customer : customers){
      if(customer.getAccount().getAccountNum().equals(accountNum)){
        System.out.print("현재 총 예금액은 " + customer.getAccount().getBalance() + "원입니다. 예금액을 입력하세요 : ");
        int deposit = sc.nextInt();
        customer.getAccount().setBalance(customer.getAccount().getBalance() + deposit);
        System.out.println("정상 입금되었습니다. 현재 총 예금액은 " + customer.getAccount().getBalance() + "원입니다.");
        return;
      }
    }
  }

  // 출금
  public void withdraw(){
    System.out.print("출금계좌번호 : ");
    String accountNum = sc.next();
    for(Customer customer : customers){
      if(customer.getAccount().getAccountNum().equals(accountNum)){
        System.out.print("현재 총 예금액은 " + customer.getAccount().getBalance() + "원입니다. 출금액을 입력하세요 : ");
        int withdraw = sc.nextInt();
        customer.getAccount().setBalance(customer.getAccount().getBalance() - withdraw);
        System.out.println("정상 출금되었습니다. 현재 총 예금액은 " + customer.getAccount().getBalance());
        return;
      }
    }
  }

  // 예금조회
  public void getAccountBalance(){
    System.out.print("계좌번호 : ");
    String accountNum = sc.next();
    for(Customer customer : customers){
      if(customer.getAccount().getAccountNum().equals(accountNum)){
        System.out.println("현재 총 예금액은 "  + customer.getAccount().getBalance() + "원입니다.");
        return;
      }
    }
  }

  // 전체조회
  public void getCustomerInfo(){
    for(int i = 0 ; i < cnt ; i++){
      System.out.println(customers[i]);
    }
  }
}
