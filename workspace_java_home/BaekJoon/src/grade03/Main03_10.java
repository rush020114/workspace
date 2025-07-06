package grade03;

import java.util.Scanner;

public class Main03_10 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int cnt = sc.nextInt();
    String[] strings = new String[cnt];
    for(int i = 0 ; i < strings.length ; i++){
    }
    for(int i = strings.length - 1 ; i > 0 ; i--){
      for(int j = 0 ; j < i ; j++){
        System.out.print(" ");
      }
        System.out.print("*");
      System.out.println();
    }
  }
}
