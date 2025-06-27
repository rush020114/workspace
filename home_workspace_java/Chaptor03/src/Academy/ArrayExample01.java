package Academy;
// 로또 중복 없는 문제

public class ArrayExample01 {
  public static void main(String[] args){
    int[] arr = new int[6];
      for(int i = 0 ; i < arr.length ; i++){
        int num =(int)(Math.random() * 45 + 1);
        if (arr[0] == num || arr[1] == num || arr[2] == num || arr[3] == num || arr[4] == num || arr[5] == num) {
          i--;
          continue;
        }
        arr[i] =  num;
        System.out.println(arr[i]);
      }
  }
}
