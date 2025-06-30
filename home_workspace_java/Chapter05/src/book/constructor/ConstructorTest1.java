package book.constructor;

public class ConstructorTest1 {
  public static void main(String[] args){
    Student kim = new Student(); // 기본 생성자 호출로 기본값으로 세팅
    kim.printInfo(); // 정수의 기본값은 0, 논리의 기본값은 false, 참조자료형의 기본값은 null이다.
  }
}
