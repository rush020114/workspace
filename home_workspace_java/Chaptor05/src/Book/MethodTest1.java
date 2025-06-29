package book;

public class MethodTest1 {
  // 메서드는 기능을 담당한다.
  // 메서드는 리턴 타입, 메서드 이름, 매개변수 목록으로 구성된다.
  // 리턴타입 : 메서드가 리턴할 데이터 선언(반드시 리턴할 데이터와 같은 자료형으로 구성하거나 리턴 키워드를 사용해야 한다.(리턴 없을 시엔 void선언)
  // 매개변수는 메서드의 기능을 수행하기 위해 필요한 데이터이다. 매개변수는 메서드 수행 종료 시 삭제된다. 매개변수는 적을수록 좋다.
  public static void main(String[] args){
    System.out.println("===> main() start"); // 자바는 메인메서드부터 시작한다.
    methodA(); // 메서드methodA를 호출하여 밑의 출력문을 잠시 미룬다.
    System.out.println("===> main() end"); // methodA가 마지막 출력문을 실행하고 나면 실행한다.
  }

  private static void methodA(){
    System.out.println("---> mehtodA() start"); // 호출된 메서드가 실행된다.
    methodB(); // 메서드 methodB를 호출하여 밑의 출력문을 잠시 미룬다.
    System.out.println("---> mehtodA() end"); // methodB호출문 실행 후 실행문
  }

  private static void methodB(){
    System.out.println("methodB 실행"); // methodB가 실행됐으므로 메서드 methodB의 호출문 다음을 실행한다.
  }

}
