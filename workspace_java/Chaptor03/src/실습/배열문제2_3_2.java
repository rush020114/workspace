package 실습;

public class 배열문제2_3_2 {
  public static void main(String[] args) {
    int[] arr1 = {1, 2, 3};
    int[] arr2 = {4, 5, 6};
    int[] newArr = new int[arr1.length + arr2.length];

    // arr1 배열의 크기(길이)만큼 반복해서 newArr에 데이터를 저장.
    for(int i = 0 ; i < arr1.length ; i++){
      newArr[i] = arr1[i];
    }
    for(int i = 0 ; i < arr2.length ; i++){
      newArr[i + arr1.length] = arr2[i];
    }
    for(int e : newArr){
      System.out.print(e + " ");
    }
  }
}
