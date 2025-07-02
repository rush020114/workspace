package example.bank;

public class AccountInfo {
  private String idenNum;
  private String accNum;
  private int balance;

  public AccountInfo(String idenNum, String accNum){
    this.idenNum = idenNum;
    this.accNum = accNum;
    balance = 10000;
  }

  public String getAccNum(){
    return accNum;
  }

  public int getBalance(){
    return balance;
  }

  public void setBalance(int balance){
    this.balance = balance;
  }

  public String getIdenNum(){
    return idenNum;
  }

}
