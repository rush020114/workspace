package yoon;

public class PhoneTest {

  // 부모 클래스는 자식 클래스의 객체를 받을 수 있지만 자식 클래스 기능밖에 쓰지 못한다.
  // 그리고 그 역은 성립하지 않는다.
  public static void main(String[] args){
    SmartPhone smartPhone = new SmartPhone("010-555", "Nougat");
    MobilePhone mobilePhone = new SmartPhone("010-555", "Nougat");
    smartPhone.answer();
    smartPhone.playApp();
    mobilePhone.answer();

  }
}
