package 실습;

public class 배열문제09_1 {
  public static void main(String[] args) {
    int[] arr = {1, 5, 7};
    int sum = 0;
    for(int e : arr){
      sum = sum + e;
    }
    System.out.println(sum);
  }
}
