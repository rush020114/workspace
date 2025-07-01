package account;


import java.util.Scanner;

public class Banking {
  private CustomerInfo[] customerInfos;
  int cnt;
  Scanner sc;

  public Banking(){
    cnt = 0;
    customerInfos = new CustomerInfo[5];
    sc = new Scanner(System.in);
  }

  // 계좌 등록 메서드
  public void regAccount(){
    if(cnt >= 3){
      System.out.println("계좌 등록 인원을 초과하였습니다.");
      return;
    }
    customerInfos[cnt++] = createAccount();
  }

  // 입금 메서드
  public void deposit(){
    System.out.print("입금 계좌 번호 : ");
    String depositAccNum = sc.next();
    boolean isNotFound = true;
    for(int i = 0 ; i < cnt ; i++){
      if(customerInfos[i].getAccountInfo().getAccNum().equals(depositAccNum)){
        System.out.print("현재 총 예금액은 " + customerInfos[i].getAccountInfo().getBalance() + "입니다. 예금액을 입력하세요 : ");
        customerInfos[i].getAccountInfo().deposit(sc.nextInt());
        System.out.println("정상 입금되었습니다. 현재 총 예금액은 " + customerInfos[i].getAccountInfo().getBalance() + "입니다.");
        isNotFound = !isNotFound;
      }
    }
    if(isNotFound){
      System.out.println("없는 계좌번호입니다.");
    }
  }

  // 출금 메서드
  public void withdraw(){
    System.out.print("출금 계좌 번호 : ");
    String withdrawAccNum = sc.next();
    boolean isNotFound = true;
    for(int i = 0 ; i < cnt ; i++){
      if(customerInfos[i].getAccountInfo().getAccNum().equals(withdrawAccNum)){
        System.out.print("현재 총 예금액은 " + customerInfos[i].getAccountInfo().getBalance() + "입니다. 출금액을 입력하세요 : ");
        customerInfos[i].getAccountInfo().withdraw(sc.nextInt());
        isNotFound = !isNotFound;
      }
    }
    if(isNotFound){
      System.out.println("없는 계좌번호입니다.");
    }
  }

  // 예금 조회
  public void checkbalance(){
    System.out.print("계좌번호 : ");
    String accNum = sc.next();
    boolean isNotFound = true;
    for(int i = 0 ; i < cnt ; i++){
      if(customerInfos[i].getAccountInfo().getAccNum().equals(accNum)){
        System.out.println("현재 총 예금액은 " + customerInfos[i].getAccountInfo().getBalance() + "입니다.");
        isNotFound = !isNotFound;
      }
    }
    if(isNotFound){
      System.out.println("없는 계좌번호입니다.");
    }
  }

  // 전체조회
  public void checkAll(){
    for(int i = 0 ; i < cnt ; i++){
      customerInfos[i].getCustomerInfo();
    }
  }

  // 계좌 등록 메서드의 실기능을 하는 메서드
  public CustomerInfo createAccount(){
    System.out.println("계좌 계설을 시작합니다.");
    System.out.print("이름 : ");
    String name = sc.next();
    System.out.print("주민등록번호 : ");
    String idenNum = sc.next();
    System.out.print("연락처 : ");
    String tel = sc.next();
    System.out.print("계좌번호 : ");

    // 계좌번호를 입력하면 AccountInfo에 계좌가 등록되면서 10000원 입금
    AccountInfo accountInfo = new AccountInfo(sc.next());
    // 계좌번호가 입력되면서 customerInfo에 고객 정보를 등록할 수 있게 됨.
    CustomerInfo customerInfo = new CustomerInfo(name, idenNum, tel, accountInfo);
    return customerInfo;
  }
}
