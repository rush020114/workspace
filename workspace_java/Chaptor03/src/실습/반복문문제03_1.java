package 실습;

public class 반복문문제03_1 {
  public static void main(String[] args) {
    int i = 2;
    while (i < 11) {
      // 실행코드
      System.out.print(i % 2 == 0 ? i + " " : "");
      i++;
    }
  }
}
