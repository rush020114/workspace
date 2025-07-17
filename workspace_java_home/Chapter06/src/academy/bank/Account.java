package academy.bank;

public class Account {
  private String accountNum;
  private int balance;

  public Account(String accountNum){
    this.accountNum = accountNum;
    this.balance = 10000;
  }

  public String getAccountNum() {
    return accountNum;
  }

  public void setAccountNum(String accountNum) {
    this.accountNum = accountNum;
  }

  public int getBalance() {
    return balance;
  }

  public void setBalance(int balance) {
    this.balance = balance;
  }
}
