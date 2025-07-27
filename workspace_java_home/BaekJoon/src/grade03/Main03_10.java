package grade03;

import java.util.Scanner;

public class Main03_10 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int rotate1 = sc.nextInt();
    int rotate2 = rotate1 - 1;
    for(int i = 0 ; i < rotate1 ; i++){
      for(int j = rotate2 ; j > 0 ; j--){
        System.out.print(" ");
      }
      for(int k = 0 ; k <= i ; k++){
        System.out.print("*");
      }
      rotate2--;
      System.out.println();
    }
  }
}
