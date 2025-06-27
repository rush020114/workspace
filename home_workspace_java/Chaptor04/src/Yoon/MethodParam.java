package Yoon;

public class MethodParam {
  public static void main(String[] args){
    double myHeight = 175.9;
    hiEveryone(12, 12.5); // hiEveryone에 정수 12와 실수 12.5를 전달하며 호출
    hiEveryone(13, myHeight); // 마찬가지로 메서드에 적힌 순서대로 정수와 실수를 전달하며 호출
    byEveryone(); // 매개변수 정보가 없으므로 비워져 있음.
  }

  public static void hiEveryone(int age, double height){
    System.out.println("제 나이는 " + age + "입니다.");
    System.out.println("제 키는 " + height + "cm입니다.");
  }
  public static void byEveryone(){ // 단순 출력이므로 기능에 필요한 매개변수가 필요 없음.
    System.out.println("다음에 뵙겠습니다.");
  }
}
