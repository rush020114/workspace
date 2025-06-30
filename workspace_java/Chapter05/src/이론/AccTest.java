package 이론;

public class AccTest {
  public static void main(String[] args){
    // 초기화
    // - 모든 다른 기능보다 먼저 실행되어야 함.
    // - 초기화는 최초 1회만 실행되어야 한다.

    // 클래스명 객체명 = new 생성자호출();
    Account acc1 = new Account(); // 매개변수를 필요로 하지 않는 생성자 호출
    acc1.printAcc();

    Account acc2 = new Account(1000); // 정수형 매개변수만 필요로 하는 생성자 호출
    acc2.printAcc();

    Account acc3 = new Account("1111", 5000, "kim"); // 클래스의 모든 멤버변수를 초기화하는 생성자
    acc3.printAcc();
    // acc.initAcc("11", 1000, "kim");
    // acc.printAcc();
  }
}
