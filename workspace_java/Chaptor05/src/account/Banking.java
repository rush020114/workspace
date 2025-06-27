package account;

import java.util.Scanner;

public class Banking {
  private AccountInfo accountInfo;
  private CustomerInfo customerInfo;
  Scanner sc;

  public Banking(AccountInfo accountInfo, CustomerInfo customerInfo){
    this.accountInfo = accountInfo;
    this.customerInfo = customerInfo;
    sc = new Scanner(System.in);
  }

  public void regAccount(){
    
  }

  public CustomerInfo createAccount(){
    System.out.println("계좌 계설을 시작합니다.");
    System.out.print("이름 : ");
    String name = sc.next();
    System.out.print("주민등록번호 : ");
    String idenNum = sc.next();
    System.out.print("연락처 : ");
    String tel = sc.next();
    System.out.print("계좌번호 : ");
    accountInfo = new AccountInfo(sc.next());
    customerInfo = new CustomerInfo(name, idenNum, tel, accountInfo);
    return customerInfo;
  }
}
