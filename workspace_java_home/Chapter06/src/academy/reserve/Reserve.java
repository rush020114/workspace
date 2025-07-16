package academy.reserve;

import java.util.Scanner;

public class Reserve {
  Scanner sc;
  private String[] seatS;
  private String[] seatA;
  private String[] seatB;

  public Reserve(){
    sc = new Scanner(System.in);
    seatS = new String[10];
    seatA = new String[10];
    seatB = new String[10];
    for(int i = 0 ; i < seatS.length ; i++){
      seatS[i] = "___";
    }
    for(int i = 0 ; i < seatA.length ; i++){
      seatA[i] = "___";
    }
    for(int i = 0 ; i < seatB.length ; i++){
      seatB[i] = "___";
    }
  }

  // 예약
  public void reserve(){
    System.out.print("좌석구분 S<1>, A<2>, B<3> : ");
    int seatNo = sc.nextInt();
    switch (seatNo){
      case 1:
        showSeatS();
        System.out.print("이름> ");
        String name1 = sc.next();
        System.out.print("번호> ");
        int num1 = sc.nextInt();
        if(num1 >= 1 && num1 <= 10){
          seatS[num1 - 1] = name1;
          return;
        }
        System.out.println("존재하지 않는 좌석입니다.");
        break;
      case 2:
        showSeatA();
        System.out.print("이름> ");
        String name2 = sc.next();
        System.out.print("번호> ");
        int num2 = sc.nextInt();
        if(num2 >= 1 && num2 <= 10){
          seatA[num2 - 1] = name2;
          return;
        }
        System.out.println("존재하지 않는 좌석입니다.");
        break;
      case 3:
        showSeatB();
        System.out.print("이름> ");
        String name3 = sc.next();
        System.out.print("번호> ");
        int num3 = sc.nextInt();
        if(num3 >= 1 && num3 <= 10){
          seatB[num3 - 1] = name3;
          return;
        }
        System.out.println("존재하지 않는 좌석입니다.");
        break;
      default:
        System.out.println("존재하지 않는 좌석입니다.");
    }
  }

  // 조회
  public void selectReserve(){
    showSeatS();
    showSeatA();
    showSeatB();
    System.out.println("<<조회를 완료하였습니다.>>");
  }

  // 취소
  public void deleteReserve(){
    System.out.print("좌석구분 S<1>, A<2>, B<3> : ");
    int seatNo = sc.nextInt();
    switch (seatNo){
      case 1:
        showSeatS();
        System.out.print("이름> ");
        String name1 = sc.next();
        System.out.print("번호> ");
        int num1 = sc.nextInt();
        if(num1 >= 1 && num1 <= 10){
          for(int i = 0 ; i < seatS.length ; i++){
            if(seatS[i].equals(name1)){
              seatS[i] = "___";
              return;
            }
          }
        }
        System.out.println("존재하지 않는 좌석이거나 존재하지 않는 이름입니다.");
        break;
      case 2:
        showSeatA();
        System.out.print("이름> ");
        String name2 = sc.next();
        System.out.print("번호> ");
        int num2 = sc.nextInt();
        if(num2 >= 1 && num2 <= 10){
          for(int i = 0 ; i < seatA.length ; i++){
            if(seatA[i].equals(name2)){
              seatA[i] = "___";
              return;
            }
          }
        }
        System.out.println("존재하지 않는 좌석이거나 존재하지 않는 이름입니다.");
        break;
      case 3:
        showSeatB();
        System.out.print("이름> ");
        String name3 = sc.next();
        System.out.print("번호> ");
        int num3 = sc.nextInt();
        if(num3 >= 1 && num3 <= 10){
          for(int i = 0 ; i < seatB.length ; i++){
            if(seatB[i].equals(name3)){
              seatB[i] = "___";
              return;
            }
          }
        }
        System.out.println("존재하지 않는 좌석이거나 존재하지 않는 이름입니다.");
        break;
      default:
        System.out.println("존재하지 않는 좌석입니다.");
    }
  }

  public void showSeatS(){
    System.out.print("S>");
    for(String e : seatS){
      System.out.print(e + " ");
    }
    System.out.println();
  }
  public void showSeatA(){
    System.out.print("A>");
    for(String e : seatA){
      System.out.print(e + " ");
    }
    System.out.println();
  }
  public void showSeatB(){
    System.out.print("B>");
    for(String e : seatB){
      System.out.print(e + " ");
    }
    System.out.println();
  }

}
