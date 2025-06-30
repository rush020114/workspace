package 이론;

public class While_1 {
  public static void main(String[] args) {
    System.out.println("프로젝트 시작");
    // while문의 해석 순서는 반복 조건이 거짓이면 종료하기 때문에 반복 조건 해석이 마지막이다.
    // "안녕하세요"를 5번 출력

    // 반복의 시작 지점
    int num = 1;
    while (num < 6) { // num이 6보다 작으면... 반복 조건
      System.out.println("안녕하세요");
      num += 1; // 반복 조건을 파기하는 코드
    }
    System.out.println("프로그램 종료");
  }
}