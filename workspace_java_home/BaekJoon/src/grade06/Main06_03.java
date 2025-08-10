package grade06;

import java.util.Scanner;

public class Main06_03 {
  public static void main(String[] arg){
    Scanner sc = new Scanner(System.in);
    int cnt = sc.nextInt();
    int index = cnt - 1;
    for(int i = 0 ; i < cnt ; i++){
      int l = i + 1;
      for(int k = index-- ; k > 0 ; k--){
        System.out.print(" ");
      }
      for(int j = 0 ; j < l * 2 - 1 ; j++){
        System.out.print("*");
      }
      System.out.println();
    }
    for(int i = 0 ; i < cnt ; i++){
      int l = cnt - (i + 1);
      for(int j = 0 ; j <= i ; j++){
        System.out.print(" ");
      }
      for(int k = 0 ; k < l * 2 - 1 ; k++){
        System.out.print("*");
      }
      System.out.println();
    }
  }
}
