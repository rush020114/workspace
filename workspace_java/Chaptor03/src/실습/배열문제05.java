package 실습;

public class 배열문제05 {
  public static void main(String[] args) {
    int[] arr1 = new int[5];
    for(int i = 0 ; i < arr1.length ; i++){
      if(i % 2 == 0 && i != 0){
        System.out.println(arr1[i]);
      }
    }
  }
}
