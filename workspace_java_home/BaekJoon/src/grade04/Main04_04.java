package grade04;

import java.util.Scanner;

public class Main04_04 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int[] ints = new int[9];
    for(int i = 0 ; i < ints.length ; i++){
      ints[i] = sc.nextInt();
    }
    int max = ints[0];
    int cnt = 1;
    for(int i = 0 ; i < ints.length ; i++){
      if(max < ints[i]){
        max = ints[i];
        cnt = i + 1;
      }

    }
    System.out.println(max);
    System.out.println(cnt);
  }
}
