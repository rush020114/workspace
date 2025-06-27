package 실습;

public class 배열문제08 {
  public static void main(String[] args) {
    // 0번째 요소에 1을 넣는다. 1번째 요소에 1+1을 넣는다. 2번째 요소에 1+1+1을 넣는다.
    int[] arr1 = new int[10];
    int sum = 0;
    for(int i = 0 ; i < arr1.length ; i++){
      arr1[i] = i + 1;
      System.out.println(arr1[i]);
    }
  }
}
