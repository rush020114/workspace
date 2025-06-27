package 실습;

public class 반복문문제06 {
  public static void main(String[] args) {
    // 0. 3의 배수의 개수를 저장할 변수를 0으로 초기화
    // 1. 1~100까지 반복하면서 각각의 숫자가 3의 배수인지 확인한다.
    // 2. 3의 배수라면 3의 배수의 개수를 저장하고 있는 변수의 값을 1증가시킨다.
    int i = 1;
    int cnt = 0;
    // 1 ~ 100까지 반복
    while (i < 101) {
      if (i % 3 == 0) { // 숫자가 3의 배수라면
        cnt++; // cnt 값 1증가
      }
      i++;
    }
    System.out.println(cnt);
  }
}
