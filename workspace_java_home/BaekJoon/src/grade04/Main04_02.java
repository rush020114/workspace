package grade04;

import java.util.Scanner;

public class Main04_02 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int[] ints = new int[sc.nextInt()];
    int x = sc.nextInt();

    for(int i = 0 ; i < ints.length ; i++){
      ints[i] = sc.nextInt();
    }

    for(int e : ints){
      if(e < x){
        System.out.print(e + " ");
      }
    }
  }
}
