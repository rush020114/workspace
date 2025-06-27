package Grade02;

import java.util.Scanner;

public class Main02_06 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int hour = sc.nextInt();
    int minute = sc.nextInt();
    int time = sc.nextInt();
    for(int i = 1 ; i < 18 ; i++){
      if((hour > 23 || hour < 0) || (minute > 59 || minute < 0) || (time > 1000)){
        break;
      }
      if(time + minute >= 60 * i && time + minute < 60 * (i + 1)){
        if (hour == 23) {
          System.out.print(hour - 24 + i + " ");
        }
        else if(hour + ((time + minute) / 60) > 23){
          System.out.print(hour - 24 + ((time + minute) / 60) + " ");
        }
        else{
          System.out.print(hour + i + " ");
        }
        System.out.println((time + minute) - (60 * i));
        break;
      }
      else if(time + minute < 60){
        System.out.print(hour + " ");
        System.out.println(time + minute);
        break;
      }
    }
  }
}