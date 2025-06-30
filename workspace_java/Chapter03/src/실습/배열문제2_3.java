package 실습;

public class 배열문제2_3 {
  public static void main(String[] args) {
    int[] arr1 = {1, 2, 3};
    int[] arr2 = {4, 5, 6};
    int[] newArr = new int[arr1.length + arr2.length];
    for(int i = 0 ; i < newArr.length ; i++){
      if(i < arr1.length){
        newArr[i] = arr1[i];
      }
      else{
        newArr[i] = arr2[i - arr2.length];
      }
      System.out.println(newArr[i]);
    }
  }
}
