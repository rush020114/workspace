package 실습;

public class 반복문문제07_1 {
  public static void main(String[] args) {
    int cnt = 0;
    for(int i = 1 ; i < 101 ; i++){
      if (i % 5 == 0) {
        System.out.println(i);
        cnt++;
      }
    }
    System.out.println(cnt);
  }
}
