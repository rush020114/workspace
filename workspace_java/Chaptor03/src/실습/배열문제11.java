package 실습;

public class 배열문제11 {
  public static void main(String[] args) {
    int[] arr1 = new int[8];
    int cnt = 0;
    for(int i = 0 ; i < arr1.length ; i++){
      arr1[i] = i + 1;
      if(arr1[i] % 2 == 0){
        cnt++;
      }
    }
    System.out.println(cnt);
  }
}
