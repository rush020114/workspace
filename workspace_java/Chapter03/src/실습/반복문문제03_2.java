package 실습;

public class 반복문문제03_2 {
  public static void main(String[] args) {
    for(int i = 2 ; i < 11 ; i += 2){
      System.out.println(i);
    }

    for(int j = 2 ; j < 11 ; j++){
      if (j % 2 == 0) {
        System.out.println(j);
      }
    }
  }
}
