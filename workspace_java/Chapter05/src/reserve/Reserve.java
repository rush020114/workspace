package reserve;

import java.util.Scanner;

public class Reserve {
  private Seat seat;
  Scanner sc;

  public Reserve(){
    seat = new Seat();
    sc = new Scanner(System.in);
  }

  // 예약
  public void reservation(){
    System.out.print("좌석구분 S<1>, A<2>, B<3> : ");
    switch(sc.nextInt()){
      case 1:
        seat.showSeatS();
        seat.reserveSeatS();
        break;
      case 2:
        seat.showSeatA();
        seat.reserveSeatA();
      break;
      case 3:
        seat.showSeatB();
        seat.reserveSeatB();
      break;
      default:
        System.out.println("존재하지 않는 좌석입니다.");
    }
  }

  // 조회
  public void showSeatInfo(){
    seat.showSeatS();
    seat.showSeatA();
    seat.showSeatB();
    System.out.println("<<<조회를 완료하였습니다.>>>");
  }

  // 취소
  public void cancel(){
    System.out.print("좌석구분 S<1>, A<2>, B<3> : ");
    switch(sc.nextInt()){
      case 1:
        seat.showSeatS();
        seat.cancelSeatS();
        break;
      case 2:
        seat.showSeatA();
        seat.cancelSeatA();
        break;
      case 3:
        seat.showSeatB();
        seat.cancelSeatB();
        break;
      default:
        System.out.println("존재하지 않는 좌석입니다.");
    }
  }
}
