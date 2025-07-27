package grade03;

import java.util.Scanner;

public class Main03_12 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int[] ints = new int[5];
    for(int i = 0 ; i < 5 ; i++){
      int num1 = sc.nextInt();
      int num2 = sc.nextInt();
      ints[i] = num1 + num2;
    }

    for(int e : ints){
      System.out.println(e);
    }
  }
}
