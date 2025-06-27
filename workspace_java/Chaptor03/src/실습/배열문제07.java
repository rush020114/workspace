package 실습;

public class 배열문제07 {
  public static void main(String[] args) {
    int[] arr1 = new int[10];
    for(int i = 0 ; i < arr1.length ; i++){
      arr1[i] = arr1[i] + 3;
      System.out.print(arr1[i] + " ");
    }
  }
}
