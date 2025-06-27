package 실습;

public class Break문제01 {
  public static void main(String[] args) {
    for(int i = 1 ; i < 11 ; i++){
      if(i % 2 != 0){
        continue;
      }
      System.out.println(i);
    }
  }
}
