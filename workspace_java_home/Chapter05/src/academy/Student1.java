package academy;

public class Student1 {
  // 클래스 : 데이터(변수)와 기능(메서드)을 공유하는 유사한 성질의 객체를 그룹화한 것.
  // 클래스는 사용자 정의 '자료형'이다.
  // 클래스는 설계도라 생각해도 된다.

  // 클래스의 구성 : 멤버변수(필드), 메서드, 생성자
  // 멤버변수 : 클래스 안에서 선언된 변수(어떤 데이터를 저장하고 보관)
  // 메서드 : 클래스의 메서드는 정의 부분을 말한다.(멤버변수와 연관된 기능)
  // 생성자 : 클래스를 통해 객체를 생성하게 해준다.(주로 멤버변수 초기화를 하는 역할)

  // 멤버
  String name;
  int age;

  // 생성자
  public Student1(){
    name = "김자바";
    age = 20;
  }

  // 메서드의 정의(1)
  public void setInfo(String name1, int age1){ // 매개변수로 name1과 age1을 받음
    name = name1; // 매개변수 값을 멤버변수에 저장해 값을 다시 저장
    age = age1;
  }

  // 메서드의 정의(2)
  public void displayInfo(){
    System.out.println("이름 : " + name); // 현 클래스의 멤버변수 값 출력
    System.out.println("나이 : " +age);
  }
}
