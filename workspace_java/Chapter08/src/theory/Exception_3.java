package theory;

import example.Student;

import java.util.Scanner;

public class Exception_3 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    // sc 사용 후 ...
    // 예외 발생 ...

    sc.close(); // sc 사용을 그만하겠다는 뜻(예외발생 시 이 메서드를 호출하지 못할 수 있기 때문에 예외처리 시에 finally를 사용한다.)
    Student stu = new Student("lee", 80, 100, 90);

    try{
      System.out.println(stu.getName());
    } catch (NullPointerException e){ // 학생이 없어서 학생을 생성해주는 catch 문
      System.out.println("학생이 null이어서 예외처리 됩니다.");
      stu = new Student("kim", 90, 100, 80);
      System.out.println(stu.getName());
    } finally{ // 선택사항, 예외 발생 유무에 상관없이 무조건 실행되는 코드
      System.out.println(111);
    }

    System.out.println("프로그램 종료");
  }
}
