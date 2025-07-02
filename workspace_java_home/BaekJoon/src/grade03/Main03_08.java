package grade03;

import java.util.Scanner;

public class Main03_08 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int num = sc.nextInt();
    int[] nums = new int[num];
    int[] nums1 = new int[num];
    int[] nums2 = new int[num];
    for(int i = 0 ; i < num ; i++){
      int num1 = sc.nextInt();
      nums1[i] = num1;
      int num2 = sc.nextInt();
      nums2[i] = num2;
      nums[i] = num1 + num2;
    }
    for(int i = 0 ; i < num ; i++){
      System.out.println("Case #" + (i + 1) + ": " + nums1[i] + " + " + nums2[i] + " = " + nums[i]);
    }
  }
}
