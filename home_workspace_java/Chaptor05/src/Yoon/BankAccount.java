package Yoon;

// 기능을 위한 설계도를 만들어놓기 위해선 데이터와 기능이 필요하다.
public class BankAccount {
  String accNumber; // 계좌번호
  String ssNumber; // 주민번호
  int balance = 0; // 잔액을 위한 데이터의 멤버변수를 선언 및 초기화

  public BankAccount(String acc, String ss, int bal){ // 초기화 메서드를 대신하는 생성자
    accNumber = acc; // 초기화를 위한 과정
    ssNumber = ss;
    balance = bal;
  }

  public int deposit(int amount) { // 잔액에 예금하기 위한 기능 (기능을 위해 필요한 값은 amount)
    balance += amount;
    return balance; // 기능이 끝나고 반환할 잔액의 값(인스턴스에서 사용 가능하게 함)
  }

  public int withdraw(int amount){ // 잔액에서 출금하기 위한 기능 (매개변수로 출금할 값)
    balance -= amount;
    return balance;
  }

  public int checkMyBalance(){ // 잔액을 확인하기 위한 기능
    System.out.println(balance);
    return balance;

  }
}