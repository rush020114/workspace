package grade04;

import java.util.Scanner;

public class Main04_09 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int[] baskets = new int[sc.nextInt()];
    int[] newBaskets = new int[baskets.length];
    for(int i = 0 ; i < baskets.length ; i++){
      baskets[i] = i + 1;
      newBaskets[i] = i + 1;
    }
    int rotate = sc.nextInt();
    for(int i = 0 ; i < rotate ; i++){
      int num1 = sc.nextInt();
      int num2 = sc.nextInt();
      int num3 = num2;
      for(int j = num1 - 1 ; j <= num2 - 1 ; j++){
        if(num1 != num2){
          baskets[j] = newBaskets[num3-- - 1];
        }
      }
      for(int k = 0 ; k < baskets.length ; k++){
        newBaskets[k] = baskets[k];
      }
    }
    for(int i = 0 ; i < baskets.length ; i++){
      System.out.print(baskets[i] + " ");
    }
  }
}
