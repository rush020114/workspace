public class BreakTest1 {
  public static void main(String[] args) {
    // break문 : break문의 조건을 만족할 시 가장 가까운 반복문을 종료시킨다.
    for(int i = 1 ; i < 11 ; i++){
      if (i == 5) {
        break;
      }
      System.out.println(i);
    }
  }
}
