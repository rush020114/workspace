package grade03;

import java.util.Scanner;

public class Main03_10 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int cnt = sc.nextInt();
    for(int i = 0; i < cnt ; i++){
      for(int j = -1 ; j < i ; j++){
        System.out.print("*");
      }
      System.out.println();
    }
  }
}
