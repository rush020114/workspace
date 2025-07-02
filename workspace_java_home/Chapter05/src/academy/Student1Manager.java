package academy;

public class Student1Manager {
  public static void main(String[] args){
    // 변수는 대입연산자를 통해 값이 복사된다.
    int a = 5;
    int b = a;

    b += 5;
    System.out.println("a : " + a);
    System.out.println("b : " + b);

    Student1 student1 = new Student1();
    student1.setInfo("김자바", 20);

    Student1 student2 = student1; // 같은 자료형이므로 대입연산자 사용 가능
    // 위의 경우 두 참조변수가 같은 주소값을 가지게 되어 같은 객체를 공유하게 된다.

    student2.setInfo("이자바", 30); // Student1 객체 변수 새로 세팅
    student1.displayInfo(); // 두 참조변수는 객체를 공유하기에 변수의 값이 변경되면 똑같이 변경된다.
    System.out.println();
    student2.displayInfo();
  }
}
