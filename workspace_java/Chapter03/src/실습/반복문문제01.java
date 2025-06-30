package 실습;

public class 반복문문제01 {
  public static void main(String[] args) {
    int i = 0; // i -> index(목차, 순서)
    while (i < 5) { // 0으로 값을 지정해주고 조건을 넣으면 반복횟수를 파악하기 쉽다. 이 경우는 5번
      System.out.print("* ");
      i += 1;}
      //-----------------------------------------------
    for(int j = 0 ; j < 5 ; j += 1){
      System.out.print("*");
    }
  }
}
