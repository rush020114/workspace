public class IF_6 {
  public static void main(String[] args) {

    int x = 5;

    // if, else-if, else문은 하나의 쌍이기 때문에 조건에 부합한 문장이 나오면 다음 조건은 해석하지도 않음
    // 다시 말해 여러 조건이 참이어도 최초의 참인 조건만 실행
    if (x > 3) {
      System.out.println("A");
    }

    else if(x > 4){
      System.out.println("B");
    }
  }
}
