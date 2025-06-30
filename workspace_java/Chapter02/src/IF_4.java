public class IF_4 {
  public static void main(String[] args){
    // 변수로 생성한 정수가 5보디 크면 "A"를 출력
    // 그렇지 않으면 "B"를 출력

    int num = 7;

    // 만약에 num이 5보다 크다면
    if (num > 5) {
      System.out.println("A");
    }

    else if (num >= 7) {
      System.out.println("B");
    }

    // 그렇지 않으면
    else {
      System.out.println("c");
    }

  }
}
