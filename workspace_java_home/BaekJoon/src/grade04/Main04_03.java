package grade04;

import java.util.Scanner;

public class Main04_03 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int[] ints = new int[sc.nextInt()];
    for(int i = 0 ; i < ints.length ; i++){
      ints[i] = sc.nextInt();
    }

    int max = ints[0];
    int min = ints[0];
    for(int i = 0 ; i < ints.length ; i++){
      if(max < ints[i]){
        max = ints[i];
      }
      if(min > ints[i]){
        min = ints[i];
      }
    }
    System.out.println(min + " " + max);
  }
}
