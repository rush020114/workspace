package grade04;

import java.util.Scanner;

public class Main04_01 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int[] ints = new int[sc.nextInt()];

    for(int i = 0 ; i < ints.length ; i++){
      ints[i] = sc.nextInt();
    }
    int cnt = 0;
    int same = sc.nextInt();
    for(int e : ints){
      if(e == same){
        cnt++;
      }
    }
    System.out.println(cnt);
  }
}
