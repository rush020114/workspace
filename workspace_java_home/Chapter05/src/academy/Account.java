package academy;

public class Account {
  String owner;
  String accountNumber;
  int balance;

  // 생성자로 객체를 생성하며 멤버변수를 초기화(이 경우는 매개변수를 받아 값을 초기화)
  public Account(String owner1, String accountNumber1, int balance1){
    owner = owner1;
    accountNumber = accountNumber1;
    balance = balance1;
  }

  public void showAccountInfo(){
    System.out.println("계좌명의자 : " + owner);
    System.out.println("계좌번호 : " + accountNumber);
    System.out.println("예금액 : " + balance);
  }
}
