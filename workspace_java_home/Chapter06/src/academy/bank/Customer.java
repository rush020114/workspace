package academy.bank;

import java.util.Scanner;

public class Customer {
  private String name;
  private String idenNum;
  private String tel;
  private Account account;

  public Customer(String name, String idenNum, String tel, Account account){
    this.name = name;
    this.idenNum = idenNum;
    this.tel = tel;
    this.account = account;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getIdenNum() {
    return idenNum;
  }

  public void setIdenNum(String idenNum) {
    this.idenNum = idenNum;
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  public Account getAccount() {
    return account;
  }

  public void setAccount(Account account) {
    this.account = account;
  }

  public String toString(){
    return "이름: " + name + ", 주민등록번호: " + idenNum + ", 연락처: " + tel + ", 계좌번호: " + account.getAccountNum() + ", 예금액: " + account.getBalance();
  }
}
