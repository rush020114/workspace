package 실습;

import java.util.Arrays;

public class MethodExample01 {
  public static void main(String[] args){
    System.out.println(Arrays.toString(removeDuplicate(new int[] {1,1,2,2,3,1})));

  }

  public static int[] removeDuplicate(int[] arr){
    int arrCnt = 0;
    for(int i = 0 ; i < arr.length ; i++){
      int duplicateCnt = 0;
      for(int j = 0 ; j < i ; j++){ // 자신의 요소를 제외하고 나머지 요소를 중복확인하는 for문
        if(arr[i] == arr[j]){
          duplicateCnt++;
        }
      }
      if(duplicateCnt == 0){
        arrCnt++;
      }
    }
    int[] newArr = new int[arrCnt];

    int index = 0;
    for(int i = 0 ; i < arr.length ; i++){
      int duplicateCnt = 0;
      for(int j = 0 ; j < i ; j++){
        if(arr[i] == arr[j]){
          duplicateCnt++;
        }
      }
      if(duplicateCnt == 0){
        newArr[index++] = arr[i];
      }
    }
    return newArr;
  }
}
