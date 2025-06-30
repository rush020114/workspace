package account;

public class AccountInfo {
  private String accNum;
  private int balance;

  public AccountInfo(String accNum){
    this.accNum = accNum;
    this.balance = 10000;
  }

  public String getAccNum(){
    return accNum;
  }

  public int getBalance(){
    return balance;
  }

  public int deposit(int depositAmount){
    balance += depositAmount;
    return balance;
  }

  public int withdraw(int withdrawAmount){
    balance -= withdrawAmount;
    if(balance < 0){
      balance += withdrawAmount;
      System.out.println("잔액이 부족합니다.");
    }
    else{
      System.out.println("정상 출금되었습니다. 현재 총 예금액은 " + balance + "입니다.");
    }
    return balance;
  }
}
