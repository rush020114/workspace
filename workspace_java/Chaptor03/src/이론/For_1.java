package 이론;

public class For_1 {
  public static void main(String[] args) {
    // 반복의 시작지점, 반복조건, 반복의 파기코드를 while과 달리 한 번에 모아준 것을 for문이라 한다.
    // 가독성 측면에서 좋다.
    // 해석은 시작지점을 1, 반복조건을 2, 반복의 파기코드를 3, 실행문을 4라 했을 때
    // 1243 243 243 243 2의 방향으로 해석하면 된다.
    for(int i = 0 ; i < 5 ; i++){
      System.out.println("A");
    }
  }
}
