// 점수가 90 <= x =< 100 이면 "A"출력
// 점수가 80 <= x =< 89 이면 "B"출력
// 점수가 70 <= x =< 79 이면 "C"출력
// 점수가 70 미만이면 "D"출력
public class Switch_2 {
  public static void main(String[] args){
    int score = 100; // 0 ~ 100 사이의 점수
    switch (score / 10) {
      case 10: // switch문은 조건이 부합하면 계속 실행하므로 score가 100이면 다음으로 넘어간다.
      case 9:
        System.out.println("A");
        break;
      case 8:
        System.out.println("B");
        break;
      default:
        System.out.println("C");

    }

  }
}
