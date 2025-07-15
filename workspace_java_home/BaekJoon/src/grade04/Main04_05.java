package grade04;

import java.util.Scanner;

public class Main04_05 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int basket = sc.nextInt();
    int command = sc.nextInt();
    int[] arr = new int[basket];

    for(int i = 0 ; i < command ; i++){
      int firstBasket = sc.nextInt();
      int lastBasket =sc.nextInt();
      int ballNum = sc.nextInt();
      for(int j = firstBasket - 1 ; j <= lastBasket - 1 ; j++){
        arr[j] = ballNum;
      }
    }
    for(int e : arr){
      System.out.print(e + " ");
    }
  }
}