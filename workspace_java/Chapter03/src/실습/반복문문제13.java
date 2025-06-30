package 실습;

public class 반복문문제13 {
  public static void main(String[] args) {
    int sum = 0;

    for(int i = 1 ; i < 101 ; i++){
      if (sum > 300) {
        System.out.println(i - 1);
        break;
      }
      sum = sum + i;
    }
    System.out.println(sum);
  }
}
