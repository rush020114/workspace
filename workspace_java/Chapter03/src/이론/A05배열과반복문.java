package 이론;

public class A05배열과반복문 {
  public static void main(String[] args) {
    // 배열의 크기를 알 수 있는 명령어
    double[] arr1 = new double[7];
    System.out.println(arr1.length);

    int[] arr2 = {1,2,3};
    System.out.println(arr2.length);

    int[] arr3 = {1,2,3,4,5};
    // arr3 배열이 갖는 모든 데이터를 출력
    for(int i = 0 ; i < arr3.length ; i++){ // 배열변수.length를 쓰면 일일이 배열의 공간을 신경쓸 필요없다.
      System.out.println(arr3[i]); // 배열의 공간이 다섯 개이므로 네번째 요소까지 존재
    }

    // 배열 각 요소의 값을 1씩 증가
    for(int i = 0 ; i < arr3.length ; i++){
      arr3[i] = arr3[i] + 1;
      System.out.println(arr3[i]);
    }
  }
}
