package 실습;

public class 배열문제11_1 {
  public static void main(String[] args) {
    int[] arr = new int[8];
    for(int i = 0 ; i < arr.length ; i++){
      arr[i] = i + 1;
    }

    int cnt = 0;
    for(int e : arr){
      if (e % 2 == 0) {
        cnt++;
      }
    }
    System.out.println(cnt);
  }
}
