package academy;

public class Student1Test {
  // 클래스의 사용(객체 생성)
  // 클래스는 객체를 만들기 위한 설계도이다.(붕어빵틀)
  // 인스턴스 : 클래스에서 만들어진 실체
  // 인스턴스 생성 문법 : new 클래스명();
  // new는 새로운 인스턴스를 생성하라는 의미
  // 참조변수 : 인스턴스를 컨트롤하기 위한 변수

  // 클래스의 선언 및 인스턴스 생성 문법
  // ex) Student student = new Student();

  public static void main(String[] args){
    Student1 student1 = new Student1(); // 클래스(참조 자료형) Student1에 대한 선언 및 인스턴스 생성
    Student1 student2 = new Student1(); // 객체는 여러개 생성할 수 있다.


    // 객체를 생성하고 그 주소값을 참조하는 변수가 있으므로 변수로 객체에 접근할 수 있음.
    student1.name = "이자바"; // Student1 객체의 멤버변수에 직접 접근하여 값을 변경
    student1.age = 30;

    System.out.println("이름 : " + student1.name);
    System.out.println("나이 : " + student1.age);

    student1.setInfo("최자바", 40); // Student 객체의 메서드에 접근하여 사용하는 문법(이 경우는 객체의 멤버변수를 모두 다시 세팅)
    student1.displayInfo(); // 멤버변수를 모두 출력하는 메서드에 접근하여 사용

    student2.setInfo("박자바", 50); // 또 다른 객체를 생성해 사용함(자신과 다른 객체에 영향을 주지 않음)
    student2.displayInfo(); // student2가 참조하는 Student1 객체의 값은 변했지만 student1이 참조하는 객체는 그대로이다.

  }
}
