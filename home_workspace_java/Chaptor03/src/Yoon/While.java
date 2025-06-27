public class While {
  public static void main(String[] args) {
    // while 문 : while의 조건문이 참이면 중괄호 영역 실행을 반복 후 거짓이 될 때 빠져나옴.
    int num = 0;
    while (num < 5) {
      System.out.println("I like Java" + num);
      num++;
    }
  }
}
