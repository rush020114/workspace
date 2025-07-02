package grade02;

import java.util.Scanner;

public class Main02_07 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int num1 = sc.nextInt();
    int num2 = sc.nextInt();
    int num3 = sc.nextInt();
    int[] num = {num1, num2, num3};
    if(num1 < 7 && num1 > 0 && num2 < 7 && num2 > 0 && num3 < 7 && num3 > 0){
      if(num1 == num2 && num2 == num3 && num1 == num3){
        System.out.println(10000 + num1 * 1000);
      }

      else if(num1 != num2 && num2 != num3 && num3 != num1) {
        int max = num[0];
        for(int i = 0 ; i < num.length ; i++){
          if(num[i] > max){
            max = num[i];
          }
        }
        System.out.println(max * 100);
      }
      else{
        if(num1 == num2){
          System.out.println(1000 + num1 * 100);
        }
        else if(num2 == num3){
          System.out.println(1000 + num2 * 100);
        }
        else{
          System.out.println(1000 + num3 * 100);
        }
      }
    }
  }
}
