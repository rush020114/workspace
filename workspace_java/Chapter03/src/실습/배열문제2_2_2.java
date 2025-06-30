package 실습;

public class 배열문제2_2_2 {
  public static void main(String[] args) {
    int[] arr = {5, 4, 3, 2, 1};
    int[] newArr;
    newArr = arr; // 문법상으로는 실행이 되나 참조자료형이기 때문에 주의를 기울여 사용해야 한다.

    for(int i = 0 ; i < newArr.length ; i++){
      System.out.println(newArr[i]);
    }
  }
}
