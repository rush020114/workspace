package grade04;

import java.util.Scanner;

public class Main04_08 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int[] ints = new int[10];
    int index = 0;
    for(int i = 0 ; i < 10 ; i++){
      int num = sc.nextInt();
      ints[i] = num % 42;
    }
    for(int i = 0 ; i < ints.length ; i++){
      int cnt = 0;
      for(int j = 0 ; j < i ; j++){
        if(ints[i] == ints[j]){
          cnt++;
        }
      }
      if(cnt == 0){
        index++;
      }
    }
    System.out.println(index);
  }
}
