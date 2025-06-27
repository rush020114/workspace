package account;

public class CustomerInfo {
  private String name;
  private String idenNum;
  private String tel;
  private AccountInfo accountInfo;

  public CustomerInfo(String name, String idenNum, String tel, AccountInfo accountInfo) {
    this.name = name;
    this.idenNum = idenNum;
    this.tel = tel;
    this.accountInfo = accountInfo;
  }
}
