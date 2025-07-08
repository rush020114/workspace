package theory;

import java.util.InputMismatchException;
import java.util.Scanner;

// 프로그램에 오류가 발생해도 동작이 되도록 하는 방법이 예외처리이다.

// 예외처리 문법 (try catch 문)
// try{
//   예외 발생 소지가 있는 코드 작성
// } catch(Exception e){ 사실 Exception을 쓰는 것은 좋은 방법이 아니다. Exception의 자식 클래스를 쓰는 것이 좋다.
//   예외 발생 시 실행 코드 작성
// }
public class Exception_1 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    try{ // 예외가 발생하지 않으면 순서대로 코드를 실행한다.
      System.out.print("첫번째 수 : "); // 이 부분에서 틀리면 try 중괄호 안의 나머지를 실행하지 않고 바로 catch문을 실행한다.
      int a = sc.nextInt();
      System.out.print("두번째 수 : ");
      int b = sc.nextInt();

      System.out.println(a / b);
      // Exception 클래스는 예외 발생에 대한 모든 정보를 담고 있다.
    } catch (InputMismatchException e){ // catch문 안의 내용은 예외 발생 시에만 실행!
      System.out.println("예외 발생!");
      System.out.println(e.getMessage()); // 예외가 발생한 이유를 문자열로 리턴
      // 예외가 발생한 위치, 이유를 알려주는 메서드
      // 예외처리를 하지 않으면 printStackTrace() 메서드가 자동 호출
      e.printStackTrace();
    }
    System.out.println("프로그램 종료");
  }
}