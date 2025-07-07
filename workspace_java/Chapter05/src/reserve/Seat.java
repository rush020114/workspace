package reserve;

import java.util.Scanner;

public class Seat {
  Scanner sc;
  private Reserver[] reserversS;
  private Reserver[] reserversA;
  private Reserver[] reserversB;

  public Seat(){
    sc = new Scanner(System.in);
    reserversS = new Reserver[10];
    reserversA = new Reserver[10];
    reserversB = new Reserver[10];

    for(int i = 0 ; i < reserversS.length ; i++){
      reserversS[i] = new Reserver("___");
    }

    for(int i = 0 ; i < reserversA.length ; i++){
      reserversA[i] = new Reserver("___");
    }

    for(int i = 0 ; i < reserversB.length ; i++){
      reserversB[i] = new Reserver("___");
    }
  }

  // 예약된 좌석을 보여주는 메서드
  public void showSeatS(){
    System.out.print("S>> ");
    for(int i = 0 ; i < reserversS.length ; i++){
      System.out.print(reserversS[i]);
    }
    System.out.println();
  }

  public void showSeatA(){
    System.out.print("A>> ");
    for(int i = 0 ; i < reserversA.length ; i++){
      System.out.print(reserversA[i]);
    }
    System.out.println();
  }

  public void showSeatB(){
    System.out.print("B>> ");
    for(int i = 0 ; i < reserversB.length ; i++){
      System.out.print(reserversB[i]);
    }
    System.out.println();
  }

  // 예약
  public void reserveSeatS(){
    System.out.print("이름 : ");
    String name = sc.next();
    System.out.print("번호 : ");
    int num = sc.nextInt();
    if(num > 10){
      System.out.println("없는 좌석입니다.");
      return;
    }
    for(int i = 0 ; i < reserversS.length ; i++){
      if(num == i + 1){
        reserversS[i].setName(name);
        return;
      }
    }
  }

  public void reserveSeatA(){
    System.out.print("이름 : ");
    String name = sc.next();
    System.out.print("번호 : ");
    int num = sc.nextInt();
    if(num > 10){
      System.out.println("없는 좌석입니다.");
      return;
    }
    for(int i = 0 ; i < reserversA.length ; i++){
      if(num == i + 1){
        reserversA[i].setName(name);
        return;
      }
    }
  }

  public void reserveSeatB(){
    System.out.print("이름 : ");
    String name = sc.next();
    System.out.print("번호 : ");
    int num = sc.nextInt();
    if(num > 10){
      System.out.println("없는 좌석입니다.");
      return;
    }
    for(int i = 0 ; i < reserversB.length ; i++){
      if(num == i + 1){
        reserversB[i].setName(name);
        return;
      }
    }
  }

  // 취소
  public void cancelSeatS(){
    System.out.print("이름 : ");
    String name = sc.next();
    for(int i = 0 ; i < reserversS.length ; i++){
      if(reserversS[i].getName().equals(name)){
        reserversS[i].setName("___");
        return;
      }
    }
    System.out.println("없는 이름입니다.");
  }

  public void cancelSeatA(){
    System.out.print("이름 : ");
    String name = sc.next();
    for(int i = 0 ; i < reserversA.length ; i++){
      if(reserversA[i].getName().equals(name)){
        reserversA[i].setName("___");
        return;
      }
    }
    System.out.println("없는 이름입니다.");
  }

  public void cancelSeatB(){
    System.out.print("이름 : ");
    String name = sc.next();
    for(int i = 0 ; i < reserversB.length ; i++){
      if(reserversB[i].getName().equals(name)){
        reserversB[i].setName("___");
        return;
      }
    }
    System.out.println("없는 이름입니다.");
  }
}
