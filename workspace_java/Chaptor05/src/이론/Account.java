package 이론;

// 좋은 클래스의 전제 조건
// - 모든 멤버변수는 초기값을 갖는 것이 좋다!
// - 멤버변수 선인 시에는 초기값을 저장하지 않는 것이 좋다.
public class Account {
  String accNum;
  int money;
  String owner;

  // 생성자(Constructor) : 멤버변수의 값을 초기화하는 역할
  // 생성자는 return타입이 없다.
  // 생성자 이름은 class명과 동일!
  // 클래스에 생성자가 하나도 없으면, 내용이 없는 생성자를 자동으로 만들어줌(생성자는 여러 개 만들 수 있다.)
  // 매개변수 정보(매개변수의 자료형, 매개변수의 개수)를 다르게 지정하면 생성자를 여러개 생성할 수 있음.
  public Account(){
  }
  public Account(String a){
  }

  public Account(int money){
    accNum = "";
    this.money = money;
    owner = "";
  }

  public Account(String accNum, int money, String owner){
    this.accNum = accNum;
    this.money = money;
    this.owner = owner;
  }

  public void printAcc(){
    System.out.println("계좌번호 : " + accNum);
    System.out.println("예금액 : " + money);
    System.out.println("소유주 : " + owner);
  }

  // 메서드 오버로딩(Method Over-loading)
  // 매개변수 정보(매개변수의 자료형, 매개변수의 개수)를 다르게 지정하면 같은 메서드 명을 중복 선언할 수 있음.
  // 이를 이용하여 동일한 기능을 동일한 메서드명으로 묶을 수 있다. 예) 출력문
  public void test(){
  }

  public void test(int a){
  }

  public void test(String a){
  }
}
