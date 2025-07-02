package example.bank;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Banking { // 은행업무 클래스는 고객정보를 가지고 있고 추가할 수 있다.
  private List<CustomerInfo> customerInfoList;
  private List<AccountInfo> accountInfoList;
  Scanner sc;
  int index;

  public Banking(){
    sc = new Scanner(System.in);
    customerInfoList = new ArrayList<>();
    accountInfoList = new ArrayList<>();
    index = 0;
  }

  // 계좌개설
  public void regCustomer(){
    System.out.println("계좌개설을 시작합니다.");
    System.out.print("이름 : ");
    String name = sc.next();
    System.out.print("주민등록번호 : ");
    String idenNum = sc.next();
    System.out.print("연락처 : ");
    String tel = sc.next();
    System.out.print("계좌번호 : ");
    String accNum = sc.next();

    accountInfoList.add(new AccountInfo(idenNum, accNum));
    customerInfoList.add(new CustomerInfo(name, tel, accountInfoList.get(index)));
    index++;
  }

  // 입금
  public void deposit(){
    System.out.print("입금계좌번호 : ");
    String accNum = sc.next();
    for(CustomerInfo customerInfo : customerInfoList){
      if(customerInfo.getAccountInfo().getAccNum().equals(accNum)){
        System.out.print("현재 총 예금액은 " + customerInfo.getAccountInfo().getBalance() + "원입니다. 예금액을 입력하세요 : ");
        int newBalance = customerInfo.getAccountInfo().getBalance() + sc.nextInt();
        customerInfo.getAccountInfo().setBalance(newBalance);
        System.out.println("정상 입금되었습니다. 현재 총 예금액은 " + newBalance + "원입니다.");
        return;
      }
    }
    System.out.println("일치하는 계좌가 없습니다.");
  }

  // 출금
  public void withdraw() {
    System.out.print("출금계좌번호 : ");
    String accNum = sc.next();
    for (AccountInfo accountInfo : accountInfoList) {
      if (accountInfo.getAccNum().equals(accNum)) {
        System.out.print("현재 총 예금액은 " + accountInfo.getBalance() + "원입니다. 출금액을 입력하세요 : ");
        int balance = sc.nextInt();
        int newBalance = accountInfo.getBalance() - balance;
        accountInfo.setBalance(newBalance);
        if (newBalance < 0) {
          int returnBalance = newBalance + balance;
          accountInfo.setBalance(returnBalance);
          System.out.println("예금액이 부족합니다.");
          return;
        } else {
          System.out.println("정상 출금되었습니다. 현재 총 예금액은 " + newBalance + "원입니다.");
          return;
        }
      }
    }
    System.out.println("일치하는 계좌가 없습니다.");
  }
  // 예금조회
  public void checkMyBalance(){
    System.out.print("계좌번호 : ");
    String accNum = sc.next();
    for(CustomerInfo customerInfo : customerInfoList){
      if(customerInfo.getAccountInfo().getAccNum().equals(accNum)){
        System.out.println("현재 총 예금액은 " + customerInfo.getAccountInfo().getBalance() + "원입니다.");
        return;
      }
    }
    System.out.println("일치하는 계좌가 없습니다.");
  }

  // 계좌해지
  public void removeAccNum(){
    System.out.print("해지계좌번호 : ");
    String accNum = sc.next();
    for(int i = 0 ; i < customerInfoList.size() ; i++){
      if(customerInfoList.get(i).getAccountInfo().getAccNum().equals(accNum)){
        System.out.println(customerInfoList.get(i).getName() + "님의 계좌를 해지합니다.");
        customerInfoList.remove(i);
        return;
      }
    }
    System.out.println("일치하는 계좌가 없습니다.");
  }

  // 전체 조회
  public void checkCustomerInfoAll(){
    for(CustomerInfo customerInfo : customerInfoList){
      System.out.print("이름 : " + customerInfo.getName());
      System.out.print(" 주민등록번호 : " + customerInfo.getAccountInfo().getIdenNum());
      System.out.print(" 연락처 : " + customerInfo.getTel());
      System.out.println(" 예금액 : " + customerInfo.getAccountInfo().getBalance());
    }
  }
}
