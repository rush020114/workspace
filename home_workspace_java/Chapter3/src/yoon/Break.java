package yoon;

public class Break {
  public static void main(String[] args) {
    // break문 : 가장 가까운 반복문을 강제로 빠져나간다.
    int num = 1;
    while (num < 100) {
      if (num % 5 == 0 && num % 7 == 0) {
        break;
      }
      num++;
    }
    System.out.println("찾는 정수 : " + num);
  }
}
