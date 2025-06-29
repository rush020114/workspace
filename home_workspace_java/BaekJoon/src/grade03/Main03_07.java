package grade03;

import java.util.Scanner;

public class Main03_07 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int num = sc.nextInt();
    int[] nums = new int[num];
    for(int i = 0 ; i < num ; i++){
      int num1 = sc.nextInt();
      int num2 = sc.nextInt();
      nums[i] = num1 + num2;
    }
    for(int i = 0 ; i < num ; i++){
      System.out.println("Case #" + (i + 1) + ": " + nums[i]);
    }
  }
}
