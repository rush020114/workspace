package academy;

public class AccountManager {
  public static void main(String[] args){
    Account account = new Account("김자바", "100-100", 10000); // 생성자가 매개변수로 이 3개의 값을 받으므로 받은 값으로 초기화하여 객체를 생성
    // 객체를 컨트롤하는 참조변수 선언과 생성자를 호출하여 값을 초기화하며 새로운 객체를 생성을 동시에
    // 객체가 생성될 때 반드시 생성자가 하나 호출된다.
    // 주로 멤버변수 초기화를 하는 역할을 한다.
    // 생성자도 메서드처럼 오버로딩이 가능하다.
    // 생성자가 없으면 매개변수로 아무것도 없는 생성자가 자동으로 생긴다.(default 생성자)
    // 자동으로 초기화되면 기본값을 가진다. 참조자료형은 null을 가진다.

    account.showAccountInfo(); // 초기화된 값을 출력
  }
}
