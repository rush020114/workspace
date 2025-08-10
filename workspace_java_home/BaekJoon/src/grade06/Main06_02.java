package grade06;

import java.util.Scanner;

public class Main06_02 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int[] ints = {1, 1, 2, 2, 2, 8};
    for(int i = 0 ; i < 6 ; i++){
      ints[i] = ints[i] - sc.nextInt();
    }
    for(int e : ints){
      System.out.print(e + " ");
    }
  }
}
