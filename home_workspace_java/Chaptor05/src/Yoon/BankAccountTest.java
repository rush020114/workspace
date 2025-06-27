package Yoon;

public class BankAccountTest { // 지금의 클래스는 main메서드를 담기 위한 클래스이지 데이터와 기능을 묶기위한 클래스는 아니다.
  public static void main(String[] args){
    BankAccount myAcnt1; // BankAccount클래스를 참조할 수 있는 참조 변수 선언
    BankAccount myAcnt2;
    // new키워드는 인스턴스를 만들라는 뜻
    myAcnt1 = new BankAccount("1", "2", 3); // BankAccount 생성자를 이용하여 인스턴스를 만들어 myAcnt가 인스턴스를 갖게 하겠다.
    myAcnt2 = new BankAccount("1", "2", 3); // 인스턴스는 무제한으로 만들 수 있다.
    myAcnt1.deposit(10000); // myAcnt1이 참조하는 BankAccount의 deposit메서드 호출
    myAcnt1.checkMyBalance();
    myAcnt2.withdraw(3000);
    myAcnt2.checkMyBalance();

    BankAccount ref1 = new BankAccount("1", "2", 3); // BankAccount를 참조할 수 있는 변수선언과 생성을 동시에
    BankAccount ref2 = ref1; // 같은 참조 자료형이므로 같이 BankAccount를 참조.
    ref2.deposit(3000);
    ref1.checkMyBalance(); // BankAccount를 ref1이 ref2와 같이 참조하므로 인스턴스 데이터가 함께 변함.
    check(ref1); // ref1를 매개변수 정보로 갖는 check메서드를 호출
    // ref1 = null; null은 저장된 데이터가 없다이다.(ref1이 아무것도 참조하지 않게 된다.)
    // ref1.checkMyBalance(); checkMyBalance는 BankAccount의 기능인데 ref1이 인스턴스를 끊었으므로 오류가 생김.
  }

  public static void check(BankAccount acc){ // BankAccount 참조자료형을 매개변수로 하는 acc변수
    acc.checkMyBalance(); // BankAccount를 참조하는 acc가 checkMyBalance기능을 가진 메서드를 호출
  }
}
