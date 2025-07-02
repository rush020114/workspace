package example.bank;

public class CustomerInfo {
  private String name;
  private String tel;
  private AccountInfo accountInfo;

  public CustomerInfo(String name, String tel, AccountInfo accountInfo){
    this.name = name;
    this.tel = tel;
    this.accountInfo = accountInfo;
  }

  public String getName(){
    return name;
  }

  public String getTel(){
    return tel;
  }

  public AccountInfo getAccountInfo(){
    return accountInfo;
  }

}
