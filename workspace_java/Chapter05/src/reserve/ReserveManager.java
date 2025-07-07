package reserve;

import java.util.Scanner;

public class ReserveManager {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    Reserve reserve = new Reserve();
    boolean isRunning = true;

    while(isRunning){
      System.out.print("예약<1>, 조회<2>, 취소<3>, 끝내기<4> : ");
      int selectNo = sc.nextInt();

      switch(selectNo){
        case 1:
          reserve.reservation();
          break;
        case 2:
          reserve.showSeatInfo();
          break;
        case 3:
          reserve.cancel();
          break;
        case 4:
        default:
          isRunning = !isRunning;
      }

    }
  }

}
