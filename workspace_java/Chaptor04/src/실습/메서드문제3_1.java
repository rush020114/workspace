package 실습;

import java.util.Arrays;

public class 메서드문제3_1 {
  public static void main(String[] args){
    test1(2);
    int[] maxArr = {823, 593, 643, 234, 523};
    int result1 = test6(maxArr);
    System.out.println(result1);
    String[] strList = {"a", "b", "c"};
    String result2 = test7(strList);
    System.out.println(result2);
    int[] arr1 = {1, 2, 3};
    int[] arr2 = {2, 3, 4};
    int[] result3 = test8(arr1, arr2);
    System.out.println(result3);
    for(int i = 0 ; i < result3.length ; i++){
      System.out.println(result3[i]);
    }
    System.out.println(Arrays.toString(result3)); // for문을 사용하지 않고 배열의 요소를 출력하는 방법
    int[] oddArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    System.out.println(Arrays.toString(test9(oddArr)));
  }

  public static void test1(int num){
    for(int i = 1 ; i < 10 ; i++){
      System.out.println(num + " * " + i + " = " + (num * i));
    }
  }

  public static int test6(int[] arr){
    int max = arr[0];
    for(int i = 0 ; i < arr.length ; i++){
      if(max < arr[i]){
        max = arr[i];
      }
    }
    return max;
  }
  public static String test7(String[] arr){
    String result = "";
    for(int i = 0 ; i < arr.length ; i++){
      result = result + arr[i];
    }
    return result;
  }
  public static int[] test8(int[] arr1, int[] arr2){
    int[] resultArr = new int[arr1.length + arr2.length];
    for(int i = 0 ; i < arr1.length ; i++){
      resultArr[i] = arr1[i];
    }
    for(int i = 0 ; i < arr2.length ; i++){
      resultArr[arr1.length + i] = arr2[i];
    }
    return resultArr;
  }

  // 9. 모든 배열에서 짝수 배열만 생성
  // 매개변수로 들어온 배열의 짝수의 개수를 구함
  // 짝수의 개수만큼 공간을 자는 배열을 생성
  // 새로 생성한 배열에 매개변수로 들어온 배열 요소 중 짝수만 저장한다.
  // 배열을 리턴한다.

  public static int[] test9(int[] arr){
    int cnt = 0;
    for(int i = 0 ; i < arr.length ; i++){
      if(arr[i] % 2 == 0){
        cnt++;
      }
    }
    int[] newArr = new int[cnt];

    int index = 0; // 짝수를 newArr에 저장가능하게 하는 변수(안 될 땐 변수를 하나 더 만들어라)
    for(int i = 0 ; i < arr.length ; i++){

      if(arr[i] % 2 == 0){
        newArr[index] = arr[i];
        index++;
        // result[++index] = arr[i]; 위의 것을 한 줄로 줄이는 방법
      }
    }
    return newArr;
  }
}
