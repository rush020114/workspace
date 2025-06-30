package 실습;

public class 배열문제2_7 {
  public static void main(String[] args) {
    int[] arr = new int[10];
    System.out.print("모든 요소의 값 : ");
    for(int i = 0 ; i < arr.length ; i++){
      arr[i] = (int)((Math.random() * 100) + 1);
      System.out.print(arr[i] + " ");
    }
    System.out.println();
    int max = arr[0]; //arr[0]
    int min = arr[0]; //arr[0]
    for(int e : arr){
      max = e > max ? e : max;
      min = e < min ? e : min;
    }
    System.out.println("최댓값 : " + max);
    System.out.println("최솟값 : " + min);
  }
}
