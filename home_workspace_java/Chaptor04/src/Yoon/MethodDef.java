package Yoon;

public class MethodDef {
  public static void main(String[] args){
    System.out.println("프로그램 시작");
    hiEveryone(12); // hiEveryone 메서드에 12를 전달하며 호출 그리고 호출된 메서드 기능이 끝날 때까지 main 메서드 잠시 중지
    hiEveryone(11);
    System.out.println("프로그램 종료");
  }

  public static void hiEveryone(int num){ // 매개변수가 하나인 매서드를 정의
    System.out.println("좋은 아침입니다.");
    System.out.println("제 나이는 " + num + "입니다.");
  }
}
