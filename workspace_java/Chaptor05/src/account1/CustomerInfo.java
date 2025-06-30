package account1;

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

  public AccountInfo getAccountInfo(){
    return accountInfo;
  }

  public void getCustomerInfo(){
    System.out.println("이름 : " + name + " 주번 : " + idenNum + " 연락처 : " + tel + " 계좌번호 : " + accountInfo.getAccNum() + " 예금액 : " + accountInfo.getBalance());
  }
}

