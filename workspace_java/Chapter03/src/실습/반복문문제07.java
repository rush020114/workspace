package 실습;

public class 반복문문제07 {
  public static void main(String[] args) {
    int i = 1;
    int cnt = 0;
    while (i < 101) {
      if (i % 5 == 0) {
        System.out.println(i);
        cnt++;
      }
      i++;
    }
    System.out.println(cnt);

  }
}
