package 실습;

public class 반복문문제_13_1 {
  public static void main(String[] args) {
    int i = 1;
    int sum = 0;
    while(i < 100){
      sum = sum + i;
      if(sum > 300){
        System.out.println(sum);
        System.out.println(i);
        break;
      }
      i++;
    }
  }
}
