package book;

public class ForTest1 {
  public static void main(String[] args) {
    // for문 : 프로그램에서 몇 회를 반복해야 할지 알고 있는 경우
    // for문은 초기식 조건식 증감식이 소괄호에 감싸져 았고 중괗로에는 수행문이 들어간다.
    for(int i = 1 ; i < 11 ; i++){
      System.out.println(i);
    }
    int sum = 0;

    for(int j = 1 ; j < 11 ; j++){
      if(j % 2 != 0){ // j값이 홀수인 것만 실행하겠다.
        sum = sum + j;
      }
    }
    System.out.println("홀수의 합 : " + sum);

    int cnt = 0;
    for(int k = 1 ; k < 11 ; k++){
      if (k % 2 != 0) {
        cnt++;
      }
    }
    System.out.println("홀수의 개수 : " + cnt);
  }
}
