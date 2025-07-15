package grade04;

import java.util.Scanner;

public class Main04_06 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int basket = sc.nextInt();
    int command = sc.nextInt();
    int[] arr = new int[basket];
    for(int i = 0 ; i < arr.length ; i++){
      arr[i] = i + 1;
    }

    for(int i = 0 ; i < command ; i++){
      int firstSwitch = sc.nextInt() - 1;
      int lastSwitch = sc.nextInt() - 1;
      int box;
      box = arr[firstSwitch];
      arr[firstSwitch] = arr[lastSwitch];
      arr[lastSwitch] = box;
    }
    for(int e : arr){
      System.out.print(e + " ");
    }
  }
}
