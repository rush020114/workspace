package 실습;

public class 배열문제2_8 {
  public static void main(String[] args) {
    int[] arr = new int[100];
    for(int i = 0 ; i < arr.length ; i++){
      arr[i] = i + 1;
    }
    for(int e : arr){
      int cnt = 0;
      for(int j = 1 ; j <= e ; j++){
        if(e % j == 0) {
          cnt++;
        }
      }
      if(cnt > 2 || e == 1){
        continue;
      }
      System.out.println(e);
    }
  }
}
