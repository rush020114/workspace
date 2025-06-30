package 실습;

public class 배열문제2_2 {
  public static void main(String[] args) {
    int[] arr = new int[5];
    for(int i = arr.length - 1 ; i > -1 ; i--){
      arr[i] = (i + 1);
      System.out.println(arr[i]);
    }

    int[] newArr = new int[arr.length];
    for(int j = arr.length - 1 ; j > -1 ; j--){
      newArr[j] = arr[j];
      System.out.println(newArr[j]);
    }

  }
}
