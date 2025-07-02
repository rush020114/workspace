package yoon;

public class ForInFor {
  public static void main(String[] args) {
    // 반복문의 중첩 : 반복문 안에 반복문을 쓸 수 있다.
    for(int i = 0 ; i < 3 ; i++){
      for(int j = 0 ; j < 3 ; j++){
        System.out.print("[" +i + "," + j + "]" + " ");
      }
      System.out.println();
    }
  }
}
