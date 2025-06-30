package 실습;
// max의 값보다 큰 값이 나오면 저장된 값을 변형하는 원리
public class 배열문제2_6 {
  public static void main(String[] args) {
    int[] arr = {1, 5, 3, 8, 2};
    int max = arr[0]; // 어차피 비교할 조건에 있어서 만족할 수 있기 때문에 0번째 요소를 저장해주면 된다.
    for(int e : arr){
      if (max < e) {
        max = e;
      }
    }
    System.out.println(max);
  }
}