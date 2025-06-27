package Grade02;

import java.util.Scanner;

public class Main02_05 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int[] clock = new int[2];
    while(true){
      System.out.print("시 입력 : ");
      clock[0] = sc.nextInt();
      if(clock[0] < 24 && clock[0] > -1){
        break;
      }
  }
    while(true){
    System.out.print("분 입력 : ");
    clock[1] = sc.nextInt();
    if(clock[1] < 60 && clock[1] > -1 ){
      break;
    }
  }
    if(clock[1] < 45){
      if (clock[0] == 0) {
        System.out.println("시 : " + (clock[0] + 23));
      }
      else{
        System.out.println("시 : " + (clock[0] - 1));
      }
      System.out.println("분 : " + (clock[1] + 15));
    }
    else{
      System.out.println("시 : " + clock[0]);
      System.out.println("분 : " + (clock[1] - 45));
    }
  }
}
