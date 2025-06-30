package 실습;

public class Break문제04 {
  public static void main(String[] args) {
    int sum = 0;
    for(int i = 1 ; i < 51 ; i++) {
      if(sum > 50){
        System.out.println(i - 1);
        break;
      }
      sum = sum + i;
    }
    System.out.println(sum);
  }
}
