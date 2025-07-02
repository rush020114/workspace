package yoon;

public class ForEach {
  public static void main(String[] args){
    // 일반적인 for문
    int[] arr = {1, 2, 3, 4, 5};
    for(int i = 0 ; i < arr.length ; i++){
      System.out.println(arr[i]);
    }

    // for each문으로 위의 결과를 도출
    for(int e : arr){ // ar가 가지고 있는 모든 요소를 대상으로 이 반복문을 실행하라 단 ar의 값을 e에 순차적으로 저장하겠다.
      System.out.println(e);
    }

    // for each 활용
    int sum = 0;
    for(int e : arr){
      sum = sum + e; // 순차적으로 반복하는 arr의 각 요소를 차례로 더해서 sum에 저장하라.
    }
    System.out.println(sum);
  }
}
