public class OperatorTest6 {
  public static void main(String[] args) {
    int month = 12;
    System.out.print(month + "월은 "); // 출력문의 실행한 후 개행하지 않으므로 문장을 구성할 수 있게 된다.
    // 3월 또는 4월 또는 5월이면 봄입니다를 개행하지 않고 출력 그렇지 않으면 개행하지 않고 아무것도 출력하지 않겠다.
    System.out.print(month == 3 || month == 4 || month == 5 ? "봄입니다." : "");
    System.out.print(month == 6 || month == 7 || month == 8 ? "여름입니다." : "");
    System.out.print(month == 9 || month == 10 || month == 11 ? "가을입니다." : "");
    System.out.print(month == 12 || month == 1 || month == 2 ? "겨울입니다." : "");
  }
}
