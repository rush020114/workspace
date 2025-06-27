package Yoon;

public class BankAccountPO {
  // 프로그램은 데이터와 기능들이 모여 형성된다.
  // 데이터와 기능들을 묶어버릴 수 있는 도구가 클래스이다.
  // 클래스는 틀이고 그 틀을 이용해 다른 인스턴스들을 사용한다.(실기능을 하는 객체를 생성)
  // 클래스를 잘 만들어놓으면 객체들을 형성해 그 기능을 잘 쓸 수 있다.
  static int balance = 0;
  public static void main(String[] args){
    deposit(10000);
    withdraw(5000);
    checkMyBalance();
    System.out.println(checkMyBalance()); // 호출한 메소드는 잔액의 출력 기능까지 있으며 리턴한 값을 또 출력해야 하기에 두 번 출력.
  }

  public static int deposit(int amount){
    balance += amount;
    return balance;
  }

  public static int withdraw(int amount){
    balance -= amount;
    return balance;
  }

  public static int checkMyBalance(){
    System.out.println(balance);
    return balance;
  }
}
